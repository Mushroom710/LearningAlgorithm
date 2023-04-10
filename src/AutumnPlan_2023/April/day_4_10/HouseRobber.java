package AutumnPlan_2023.April.day_4_10;

// @date 2023/4/10
// @time 22:08
// @author zhangzhi
// @description LeetCode 198. 打家劫舍

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for(int i = 0; i < nums.length; i++){
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        //System.out.println(Arrays.toString(dp));
        return dp[nums.length + 1];
    }

    public int rob2(int[] nums){
        if(nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
