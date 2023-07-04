package AutumnPlan_2023.July.day_7_4;

// @date 2023/7/4
// @time 11:56
// @author zhangzhi
// @description LeetCode 673. 最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 1;
        int ans = 0;
        for(int i = 0; i < n; i++){
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
            if(max == dp[i]){
                ans += cnt[i];
            }else if(max < dp[i]){
                max = dp[i];
                ans = cnt[i];
            }
        }
        // Arrays.sort(cnt);
        // System.out.println(Arrays.toString(cnt));
        return ans;
    }
}
