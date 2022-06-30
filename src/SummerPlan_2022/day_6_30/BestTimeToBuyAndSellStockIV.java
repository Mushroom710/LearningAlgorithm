package SummerPlan_2022.day_6_30;

/**
 * @DATE 2022/6/30
 * @TIME 21:05
 * @Created by zhangzhi
 * @description LeetCode 188 题 买卖股票的最佳时机 IV
 */
public class BestTimeToBuyAndSellStockIV {

    // [天数][股票状态]
    // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0)return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        // dp[0][j]当j为奇数的时候都初始化为 -prices[0]
        for (int i = 1;i < 2 * k;i+=2){
            dp[0][i] = -prices[0];
        }
        // 偶数是卖、奇数是买的状态
        for (int i = 1;i < prices.length;i++){
            for (int j = 0;j < 2 * k;j+=2){
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] -prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit(2,prices));
    }
}
