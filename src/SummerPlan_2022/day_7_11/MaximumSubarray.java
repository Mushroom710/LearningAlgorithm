package SummerPlan_2022.day_7_11;

import java.util.Arrays;

/**
 * @DATE 2022/7/11
 * @TIME 21:35
 * @Created by zhangzhi
 * @description LeetCode 53 题 最大子数组和
 */
public class MaximumSubarray {

    // 贪心法 记录下每次的最大和
    public static int greedy(int[] nums){
        int re = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
            if (sum > re){
                re = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return re;
    }

    // 动态规划 dp[i] 只能从 dp[i] + nums[i] 和 nums[i] 中取最大
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        System.out.println(greedy(nums));
        System.out.println(maxSubArray(nums));
    }
}
