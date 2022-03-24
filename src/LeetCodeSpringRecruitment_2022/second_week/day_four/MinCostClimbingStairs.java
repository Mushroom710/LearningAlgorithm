package LeetCodeSpringRecruitment_2022.second_week.day_four;

import java.util.Arrays;

/**
 * @DATE 2022/3/24
 * @TIME 14:18
 * @Created by zhangzhi
 * @description LeetCode 746 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    /**
     * @create zhangzhi
     * @date 2022/3/24
     * @time 14:40
     * @description 与第三种解法相比差了点考虑
     */
    public static int solution(int[] cost){
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0],cost[1]);
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return dp[cost.length - 1];
    }

    /**
     * @create zhangzhi
     * @date 2022/3/24
     * @time 14:40
     * @description
     */
    public static int solution_two(int[] cost){
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        // 最后一级台阶可以认为不用花费，所以就是 dp数组最后两项中最小的一项
        return Math.min(dp[cost.length - 1],dp[cost.length-2]);
    }

    /**
     * @create zhangzhi
     * @date 2022/3/24
     * @time 14:39
     * @description
     * 到达第i级台阶的阶梯顶部的最小花费，有两个选择：
     *
     *     先付出最小总花费minCost[i-1]到达第i级台阶（即第i-1级台阶的阶梯顶部），
     *     踏上第i级台阶需要再花费cost[i]，
     *     再迈一步到达第i级台阶的阶梯顶部，最小总花费为minCost[i-1] + cost[i])；
     *
     *     先付出最小总花费minCost[i-2]到达第i-1级台阶（即第i-2级台阶的阶梯顶部），
     *     踏上第i-1级台阶需要再花费cost[i-1]，
     *     再迈两步跨过第i级台阶直接到达第i级台阶的阶梯顶部，
     *     最小总花费为minCost[i-2] + cost[i-1])；
     */
    public static int solution_three(int[] cost){
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0],cost[1]);
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length-1];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(solution(cost));
        System.out.println(solution_three(cost));
    }

}
