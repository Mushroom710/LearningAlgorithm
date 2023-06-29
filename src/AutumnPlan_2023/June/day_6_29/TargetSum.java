package AutumnPlan_2023.June.day_6_29;

// @date 2023/6/29
// @time 20:35
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
        target = target / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= target; j++){
                if(j < nums[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
