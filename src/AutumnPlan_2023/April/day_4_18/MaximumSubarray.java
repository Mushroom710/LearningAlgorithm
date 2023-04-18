package AutumnPlan_2023.April.day_4_18;

// @date 2023/4/18
// @time 22:09
// @author zhangzhi
// @description LeetCode 53. 最大子数组和
// 这题是求连续的最大子数组和，那么只能是相邻的比较
// 考虑 nums[i] ，可以加入子数组和和不加入子数组和
// dp[i + 1] = Math.max(dp[i] + nums[i], nums[i])
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            max = Math.max(max, dp[i + 1]);
        }
        //System.out.println(Arrays.toString(dp));
        return max;
    }
}
