package AutumnPlan_2023.April.day_4_3;

// @date 2023/4/3
// @time 21:37
// @author zhangzhi
// @description LeetCode 746. 使用最小花费爬楼梯
// 看来 +n 这个操作还是有技巧的。和具体题目有关联，需要根据题目来分析 +n 加多少。
// 反正最后的结果就是保证在遍历的过程中下标不越界

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for(int i = 1; i < cost.length; i++){
            dp[i + 1] = Math.min(dp[i] + cost[i], dp[i - 1] + cost[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for(int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }
}
