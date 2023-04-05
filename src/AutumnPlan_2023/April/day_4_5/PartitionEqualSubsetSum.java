package AutumnPlan_2023.April.day_4_5;

// @date 2023/4/5
// @time 22:10
// @author zhangzhi
// @description LeetCode 416. 分割等和子集

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0 || nums.length < 2){
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= sum; j++){
                if(j < nums[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
