package AutumnPlan_2023.April.day_4_23;

// @date 2023/4/23
// @time 10:09
// @author zhangzhi
// @description LeetCode 198. 打家劫舍
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for(int i = 0; i < n; i++){
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[n + 1];
    }
}
