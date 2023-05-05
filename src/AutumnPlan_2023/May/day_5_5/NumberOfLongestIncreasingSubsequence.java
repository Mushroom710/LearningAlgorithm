package AutumnPlan_2023.May.day_5_5;

// @date 2023/5/5
// @time 22:03
// @author zhangzhi
// @description LeetCode 673. 最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    /**
     * cnt的作用就是记录下[0, i]的最长子序列的个数！
     * 为什么要用cnt？因为在递推的过程中，子序列的个数没有保存下来，
     * 所以需要一个cnt数组记录下子序列的个数。
     */
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int ans = 0;
        int max = 1;
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
                ans = cnt[i];
                max = dp[i];
            }else if(dp[i] == max){
                ans += cnt[i];
            }
        }
        return ans;
    }
}
