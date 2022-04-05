package LeetCodeSpringRecruitment_2022.four_week.day_two;

import java.util.HashSet;
import java.util.Set;

/**
 * @DATE 2022/4/5
 * @TIME 21:14
 * @Created by zhangzhi
 * @description LeetCode 202 题 快乐数
 *
 * 经验还是不够丰富，审题还有所欠缺：
 * 之前没想到无限循环中会出现重复的可能。
 * 如果在无限循环中出现了之前计算出来的数，说明这个数不可能到1。
 */
public class HappyNumber {

    /**
     * @create zhangzhi
     * @date 2022/4/5
     * @time 21:25
     * @description 这个方法可以用来取出一个数的每一位
     */
    private static int getNum(int x){
        int re = 0;
        while(x > 0){
            int temp = x % 10;
            re += temp * temp;
            x = x / 10;
        }
        return re;
    }

    public static boolean solution(int n){
        Set<Integer> set = new HashSet<>();
        // n 不为 1 同时，n 没有在 set 中出现，可以继续循环下去
        // 如果 n 再次出现在 set 中，说明这是一个无限循环，不可能到 1
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNum(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }

}
