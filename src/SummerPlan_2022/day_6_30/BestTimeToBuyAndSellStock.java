package SummerPlan_2022.day_6_30;

/**
 * @DATE 2022/6/30
 * @TIME 20:16
 * @Created by zhangzhi
 * @description LeetCode 121 题 买卖股票的最佳时机
 */
public class BestTimeToBuyAndSellStock {

    // 因为股票就买卖一次，那么贪心的想法很自然就是取最左最小值，取最右最大值，
    // 那么得到的差值就是最大利润。
    public static int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int re = 0;
        for (int i = 0;i < prices.length;i++){
            min_price = Math.min(min_price,prices[i]);// 取最左最小价格
            re = Math.max(re,prices[i] - min_price);// 直接取最大区间利润
        }
        return re;
    }

    // a.如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
    //  1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
    //  2.第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
    // b.如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
    //  1.第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
    //  2.第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：prices[i] + dp[i - 1][0]
    public static int dp_maxProfit(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        System.out.println(dp_maxProfit(nums));
    }
}
