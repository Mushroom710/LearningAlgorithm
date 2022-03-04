package LeetCode.BestTimeToBuyAndSellStock;

import java.util.Arrays;

/**
 * @DATE 2022/3/4
 * @Created by zhangzhi
 * @description LeetCode122题 买卖股票系列问题
 * 1.DFS搜索
 *  两个递归 1.买股票 2.卖股票
 * 2.贪心算法。
 *  对于这道题，只需要找到一个递增的子序列即可
 *  即 profit = max(0,prices[i]-prices[i-1])
 *  解释：要么今天买股票，要么不买
 * 3.DP 分两种情况
 * dp[0] 无持股
 * dp[1] 有持股
 * 比较这两种状态，选出最优即可
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/4
     * @time 18:53
     * @description 贪心算法
     */
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

    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/3/4
     * @time 19:28
     * @description DP解法
     * 巧妙设置买入和卖出的利润计算方式
     * 买入： profit = profit - prices[i]
     * 卖出： profit = profit + prices[i]
     * 分成两种状态：前一天买入股票和前一天没买股票
     */
    public static int solution_two(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution(prices));
        System.out.println(solution_two(prices));
    }
}
