package AutumnPlan_2023.May.day_5_11;

// @date 2023/5/11
// @time 22:11
// @author zhangzhi
// @description LeetCode 1911. 最大子序列交替和
public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length + 1][2];
        dp[0][1] = Long.MIN_VALUE / 2;
        for(int i = 0; i < nums.length; i++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] - nums[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + nums[i]);
        }
        //System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
