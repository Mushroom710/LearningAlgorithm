package LeetCode.BestTimeToBuyAndSellStock;

/**
 * @DATE 2022/3/4
 * @Created by zhangzhi
 * @description LeetCode122题
 * 1.贪心算法
 *  找到一个连续递增的子序列
 * 2.DP
 *  定义两种状态 买入和未买入
 *   dp[i][0] 记录前一天未买入股票的利润
 *   dp[i][1] 记录前一天买入股票的利润
 *
 *   买入股票，利润就减去当天的价格
 *   dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
 *   dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
 */
public class BestTimeToBuyAndSellStockII {

    //贪心法
    public static int solution(int[] prices){
        if(prices.length<2){
            return 0;
        }
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) {
                profit += Math.max(0,prices[i]-prices[i-1]);
            }
        }
        return profit;
    }

    //DP解法
    public static int solution_two(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution(prices));
        System.out.println(solution_two(prices));
    }
}
