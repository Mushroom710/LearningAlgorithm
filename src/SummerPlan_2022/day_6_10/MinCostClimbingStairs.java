package SummerPlan_2022.day_6_10;

/**
 * @DATE 2022/6/10
 * @TIME 19:48
 * @Created by zhangzhi
 * @description LeetCode 746 题 使用最小花费爬楼梯
 * 爬到阶梯顶，就是指 idx > cost.length
 * 所以最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i < cost.length;i++){
            // 选最小的，所以 dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
            // 注意这里为什么是加 cost[i]，而不是 cost[i-1],cost[i-2] 之类的，因为题目中说了：每当你爬上一个阶梯你都要花费对应的体力值
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        // 注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
