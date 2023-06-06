package AutumnPlan_2023.June.day_6_6;

// @date 2023/6/6
// @time 10:28
// @author zhangzhi
// @description LeetCode 673. 最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int ans = 1;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = cnt[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }else if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max < dp[i]){
                max = dp[i];
                ans = cnt[i];
            }else if(max == dp[i]){
                ans += cnt[i];
            }
        }
        return ans;
    }
}
