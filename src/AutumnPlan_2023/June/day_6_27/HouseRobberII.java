package AutumnPlan_2023.June.day_6_27;

// @date 2023/6/27
// @time 12:04
// @author zhangzhi
// @description LeetCode 213. 打家劫舍 II
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp1 = new int[n + 2];
        int[] dp2 = new int[n + 2];
        int[] dp3 = new int[n + 2];
        // 偷第一家
        for(int i = 0; i < n - 1; i++){
            dp1[i + 2] = Math.max(dp1[i + 1], dp1[i] + nums[i]);
        }
        // 不偷第一家
        for(int i = 1; i < n; i++){
            dp2[i + 2] = Math.max(dp2[i + 1], dp2[i] + nums[i]);
        }
        // 都不偷
        for(int i = 1; i < n - 1; i++){
            dp3[i + 2] = Math.max(dp3[i + 1], dp3[i] + nums[i]);
        }
        return Math.max(dp1[n], Math.max(dp2[n + 1], dp3[n]));
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n + 2]; // 偷nums[0]，那么nums[1]和nums[n-1]不能偷，区间[2,n-2]
        int[] dp2 = new int[n + 2]; // 不偷nums[0]，问题变成区间[1,n-1]
        for(int i = 2; i < n - 1; i++){
            dp1[i + 2] = Math.max(dp1[i + 1], dp1[i] + nums[i]);
        }
        for(int i = 1; i < n; i++){
            dp2[i + 2] = Math.max(dp2[i + 1], dp2[i] + nums[i]);
        }
        // dp1是偷nums[0]的，所以要加上nums[0]的价值
        return Math.max(dp1[n] + nums[0], dp2[n + 1]);
    }
}
