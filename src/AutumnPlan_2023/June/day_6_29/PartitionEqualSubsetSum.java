package AutumnPlan_2023.June.day_6_29;

// @date 2023/6/29
// @time 20:36
// @author zhangzhi
// @description LeetCode 416. 分割等和子集
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
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
