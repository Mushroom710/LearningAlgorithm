package SummerPlan_2022.day_6_30;

/**
 * @DATE 2022/6/30
 * @TIME 21:18
 * @Created by zhangzhi
 * @description LeetCode 309 题 最佳买卖股票时机含冷冻期
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    // 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
    //  卖出股票状态，这里就有两种卖出股票状态
    // 状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
    // 状态三：今天卖出了股票
    // 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
    // 达到买入股票状态（状态一）即：dp[i][0]，有两个具体操作：
    //
    // 1.操作一：前一天就是持有股票状态（状态一），dp[i][0] = dp[i - 1][0]
    // 2.操作二：今天买入了，有两种情况
    //  前一天是冷冻期（状态四），dp[i - 1][3] - prices[i]
    //  前一天是保持卖出股票状态（状态二），dp[i - 1][1] - prices[i]
    //  所以操作二取最大值，即：max(dp[i - 1][3], dp[i - 1][1]) - prices[i]
    //  那么dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
    // 3.达到保持卖出股票状态（状态二）即：dp[i][1]，有两个具体操作：
    //  操作一：前一天就是状态二
    //  操作二：前一天是冷冻期（状态四）
    //  dp[i][1] = max(dp[i - 1][1], dp[i - 1][3]);
    // 4.达到今天就卖出股票状态（状态三），即：dp[i][2] ，只有一个操作：
    //  操作一：昨天一定是买入股票状态（状态一），今天卖出
    //  即：dp[i][2] = dp[i - 1][0] + prices[i];
    // 5.达到冷冻期状态（状态四），即：dp[i][3]，只有一个操作：
    //  操作一：昨天卖出了股票（状态三）
    //  dp[i][3] = dp[i - 1][2];
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],Math.max(dp[i - 1][3],dp[i - 1][1]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][3],Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
