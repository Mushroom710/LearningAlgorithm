package AutumnPlan_2023.June.day_6_7;

// @date 2023/6/7
// @time 11:17
// @author zhangzhi
// @description LeetCode 1911. 最大子序列交替和
public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        for(int i = 0; i < n; i++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + nums[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - nums[i]);
        }
        // System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[n][0], dp[n][1]);
    }
}
