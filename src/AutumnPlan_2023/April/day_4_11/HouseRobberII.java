package AutumnPlan_2023.April.day_4_11;

// @date 2023/4/11
// @time 22:08
// @author zhangzhi
// @description LeetCode 213. 打家劫舍 II

public class HouseRobberII {

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len + 2];
        for(int i = 0; i < len - 1; i++){
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        int[] dp2 = new int[len + 2];
        for(int i = 1; i < len; i++){
            dp2[i + 2] = Math.max(dp2[i + 1], dp2[i] + nums[i]);
        }
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(dp2));

        return Math.max(dp[len], dp2[len + 1]);
    }
}
