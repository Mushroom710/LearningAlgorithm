package AutumnPlan_2023.April.day_4_24;

// @date 2023/4/24
// @time 21:34
// @author zhangzhi
// @description LeetCode 494. 目标和
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums){
            target += num;
        }
        if(target < 0 || target % 2 != 0){
            return 0;
        }
        int p = target / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][p + 1];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= p; j++){
                if(j < nums[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][p];
    }
}
