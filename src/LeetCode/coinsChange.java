package LeetCode;

import java.util.Arrays;

/**
 * @DATE 2022/3/16
 * @TIME 21:34
 * @Created by zhangzhi
 * @description LeetCode 322 题 零钱兑换
 * 这个题可以转换为爬楼梯问题
 * coins数组即代表一次可以上几级台阶，而 amount 就是总的台阶数
 * 计算出最少的步数到达 amount
 *
 * 1.暴力求解（深度搜索）
 * 先计算出每个步数最多可以走几次
 * 然后一次递归这些步数
 * 最后返回 count
 * a.优化：可以先从步数最大的开始深搜
 * 2.贪心（不太适用）
 *  对于：coins={1,6,7} , amount = 30
 *   每次先选最大的步数
 *   4*7 + 1*2 = 6
 *   6*5       = 5
 * 3.动态规划
 *  即转成爬楼梯问题
 *  a.状态定义：
 *      dp[i]：上到 i 级台阶的最少步数
 *  b.递推方程：
 *      dp[i] = min{dp[i - coins[j]]} + 1
 *      解释：
 *      可以从先前的任何一级走上来
 *      走的步数是 coins[j]
 */
public class coinsChange {

    /**
     * @create zhangzhi
     * @date 2022/3/16
     * @time 21:42
     * @description 动态规划解法
     */
    public static int solution(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(solution(coins,11));
    }
}
