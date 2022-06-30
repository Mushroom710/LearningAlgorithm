package SummerPlan_2022.day_6_30;

/**
 * @DATE 2022/6/30
 * @TIME 20:33
 * @Created by zhangzhi
 * @description LeetCode 122 题 买卖股票的最佳时机 II
 */
public class BestTimeToBuyAndSellStockII {

    // dp[i][0] 表示第i天持有股票所得现金。
    // dp[i][1] 表示第i天不持有股票所得最多现金
    // 如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
    //  1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
    //  2.第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：dp[i - 1][1] - prices[i]
    // 在来看看如果第i天不持有股票即dp[i][1]的情况， 依然可以由两个状态推出来
    //  1.第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
    //  2.第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：prices[i] + dp[i - 1][0]
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
