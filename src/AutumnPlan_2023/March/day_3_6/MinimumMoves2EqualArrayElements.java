package AutumnPlan_2023.March.day_3_6;

// @date 2023/3/6
// @time 20:48
// @author zhangzhi
// @description LeetCode 453. 最小操作次数使数组元素相等
// 当一个事件比较复杂，不好求得时候，我们通常可以考虑转化为：求其对立事件。 -- 概率论思想

import java.util.Arrays;

public class MinimumMoves2EqualArrayElements {

    /**
     * 能用，但是会超时
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        int max = nums[n - 1];
        long sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
        }
        while(true){
            if(sum % n == 0){
                long div = sum / n;
                if(div >= max){
                    return count;
                }
            }
            sum += n - 1;
            count++;
        }
    }

    /**
     * n-1个元素加 1，等同于 剩下那个元素减 1。注意这个关键点！！
     * 然后统计出每个元素和最下的那个元素的差值，就是最小次数
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums){
        Arrays.sort(nums);
        int min = nums[0];
        int total = 0;
        for(int num : nums){
            total += num - min;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,99};
        System.out.println(minMoves(nums));
        System.out.println(minMoves2(nums));
    }
}
