package AutumnPlan_2023.April.day_4_24;

// @date 2023/4/24
// @time 21:46
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
        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= sum; j++){
                if(j < nums[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][sum];
    }
}
