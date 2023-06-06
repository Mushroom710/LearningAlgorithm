package AutumnPlan_2023.June.day_6_6;

// @date 2023/6/6
// @time 10:28
// @author zhangzhi
// @description LeetCode 300. 最长递增子序列
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
