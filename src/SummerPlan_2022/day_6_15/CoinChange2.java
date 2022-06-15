package SummerPlan_2022.day_6_15;

/**
 * @DATE 2022/6/15
 * @TIME 20:26
 * @Created by zhangzhi
 * @description LeetCode 518 题 零钱兑换 II
 * 1.确定dp数组以及下标的含义
 *  dp[j]：凑成总金额j的货币组合数为dp[j]
 * 2.确定递推公式
 *  dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）相加。
 *  所以递推公式：dp[j] += dp[j - coins[i]];
 *
 * 在求装满背包有几种方案的时候，认清遍历顺序是非常关键的。
 *  1.如果求组合数就是外层 for循环遍历物品，内层 for遍历背包。
 *  2.如果求排列数就是外层 for遍历背包，内层 for循环遍历物品。
 */
public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0;i < coins.length;i++){
            for (int j = coins[i];j <= amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(change(5,coins));
    }
}
