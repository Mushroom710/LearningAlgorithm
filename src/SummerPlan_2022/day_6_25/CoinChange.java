package SummerPlan_2022.day_6_25;

import java.util.Arrays;

/**
 * @DATE 2022/6/25
 * @TIME 17:48
 * @Created by zhangzhi
 * @description LeetCode 322 题 零钱兑换
 * 确定递推公式
 *  1.得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。
 *  2.凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上一个钱币coins[i]
 *    即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
 *  3.所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
 *  4.递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0;i < coins.length;i++){
            for (int j = coins[i];j <= amount;j++){
                if (dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins,3));
    }
}
