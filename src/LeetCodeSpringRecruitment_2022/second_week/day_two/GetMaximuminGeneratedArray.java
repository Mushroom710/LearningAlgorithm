package LeetCodeSpringRecruitment_2022.second_week.day_two;

import java.util.Arrays;

/**
 * @DATE 2022/3/22
 * @TIME 14:50
 * @Created by zhangzhi
 * @description LeetCode 1646 题 获取生成数组中的最大值
 */
public class GetMaximuminGeneratedArray {

    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 15:07
     * @description 算出数组。最后对数组排序。返回最大值
     */
    public static int solution(int n){
        if(n < 2){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            if((i & 1) == 1){
                arr[i] = arr[i/2] + arr[i/2 + 1];
            }else {
                arr[i] = arr[i/2];
            }
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        return arr[n];
    }

    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 15:07
     * @description 用一个变量来记录最大的值。所以不用对数组排序
     */
    public static int solution_two(int n){
        if(n < 2){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int max = 1;
        for(int i = 2; i <= n; i++){
            if((i & 1) == 1){
                arr[i] = arr[i/2] + arr[i/2 + 1];
            }else {
                arr[i] = arr[i/2];
            }
            max = Math.max(max,arr[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution_two(3));
    }
}
