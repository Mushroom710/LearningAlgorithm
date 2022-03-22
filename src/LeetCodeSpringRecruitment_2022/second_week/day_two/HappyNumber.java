package LeetCodeSpringRecruitment_2022.second_week.day_two;

import java.util.HashSet;
import java.util.Set;

/**
 * @DATE 2022/3/22
 * @TIME 15:59
 * @Created by zhangzhi
 * @description LeetCode 202 题 快乐数
 * 这个题居然是简单题。。。。
 * 1.用 hash 集合判断是否出现环
 *  在快乐数变换的过程中，可能会出现环而不能到达 1
 *  这个时候就可以用 hash 集合判断
 * 2.快慢指针法
 *  x 变换的过程可以看成是一个单链表。那么就转换为判断链表是否有环的问题
 */
public class HappyNumber {

    public static int bitSqureSum(int x){
        int sum = 0;
        int cur;
        while (x > 0){ // 取出数的每一位
            cur = x % 10;
            sum += cur * cur;
            x = x / 10;
        }
        return sum;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 16:08
     * @description 使用 hash 集合判断是否有环
     */
    public static boolean solution(int n){
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = bitSqureSum(n);
        }

        return n == 1;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 16:15
     * @description 快慢指针法
     * 类似于判断链表是否有环的思想
     * 注：快指针需要选着合适的步进值。不然可能会出现与慢指针擦肩而过的情况
     */
    public static boolean solution_two(int n){
        int slow = n;
        int quick = bitSqureSum(n);
        while (quick != 1 && slow != quick){
            slow = bitSqureSum(slow);
            quick = bitSqureSum(bitSqureSum(quick));
        }
        return quick == 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution_two(2));
    }

}
