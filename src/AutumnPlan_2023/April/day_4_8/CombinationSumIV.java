package AutumnPlan_2023.April.day_4_8;

// @date 2023/4/8
// @time 22:14
// @author zhangzhi
// @description LeetCode 377. 组合总和 Ⅳ

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0;i <= target;i++){
            for (int j = 0;j < nums.length;j++){
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
