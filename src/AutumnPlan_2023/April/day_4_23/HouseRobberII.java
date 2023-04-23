package AutumnPlan_2023.April.day_4_23;

import java.util.Arrays;

// @date 2023/4/23
// @time 10:09
// @author zhangzhi
// @description LeetCode 213. 打家劫舍 II
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n + 2];
        int[] dp2 = new int[n + 2];
        Arrays.fill(dp1, nums[0]);
        for(int i = 2; i < n - 1; i++){
            dp1[i + 2] = Math.max(dp1[i + 1], dp1[i] + nums[i]);
        }
        for(int i = 1; i < n; i++){
            dp2[i + 2] = Math.max(dp2[i + 1], dp2[i] + nums[i]);
        }
        return Math.max(dp1[n], dp2[n + 1]);
    }
}
