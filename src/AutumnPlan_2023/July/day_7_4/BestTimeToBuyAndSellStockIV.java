package AutumnPlan_2023.July.day_7_4;

import java.util.Arrays;

// @date 2023/7/4
// @time 11:59
// @author zhangzhi
// @description LeetCode 188. 买卖股票的最佳时机 IV
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 2][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k + 2; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);
            }
        }
        for(int j = 1; j < k + 2; j++){
            dp[0][j][0] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < k + 2; j++){
                dp[i + 1][j][0] = Math.max(dp[i][j][1] + prices[i], dp[i][j][0]);
                dp[i + 1][j][1] = Math.max(dp[i][j - 1][0] - prices[i], dp[i][j][1]);
            }
        }
        return dp[n][k + 1][0];
    }
}
