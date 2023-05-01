package AutumnPlan_2023.May.day_5_1;

// @date 2023/5/1
// @time 11:05
// @author zhangzhi
// @description LeetCode 673. 最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int max = 1;
        int ans = 0;
        for(int i = 0; i < len; i++){
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
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(cnt));

        return ans;
    }
}
