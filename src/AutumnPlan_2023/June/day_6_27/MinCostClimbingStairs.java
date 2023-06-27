package AutumnPlan_2023.June.day_6_27;

// @date 2023/6/27
// @time 12:03
// @author zhangzhi
// @description LeetCode 746. 使用最小花费爬楼梯
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for(int i = 1; i < cost.length; i++){
            dp[i + 1] = Math.min(dp[i] + cost[i], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }
}
