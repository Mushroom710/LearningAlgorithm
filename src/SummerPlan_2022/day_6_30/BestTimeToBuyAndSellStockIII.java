package SummerPlan_2022.day_6_30;

/**
 * @DATE 2022/6/30
 * @TIME 20:49
 * @Created by zhangzhi
 * @description LeetCode 123 题 买卖股票的最佳时机 III
 */
public class BestTimeToBuyAndSellStockIII {

    // 一天一共就有五个状态，
    //   0.没有操作
    //   1.第一次买入
    //   2.第一次卖出
    //   3.第二次买入
    //   4.第二次卖出
    // 需要注意：dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票
    // 达到dp[i][1]状态，有两个具体操作：
    //  1.操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
    //  2.操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
    // 同理可推出剩下状态部分
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];// 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][4] = 0;
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
