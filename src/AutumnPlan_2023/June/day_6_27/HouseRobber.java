package AutumnPlan_2023.June.day_6_27;

// @date 2023/6/27
// @time 12:02
// @author zhangzhi
// @description LeetCode 198. 打家劫舍
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for(int i = 0; i < nums.length; i++){
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[nums.length + 1];
    }
}
