package SummerPlan_2022.day_6_9;

/**
 * @DATE 2022/6/9
 * @TIME 21:26
 * @Created by zhangzhi
 * @description LeetCode 714 题 买卖股票的最佳时机含手续费
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * @create zhangzhi
     * @date 2022/6/9
     * @time 21:34
     * @description
     * 如果使用贪心策略，就是最低值买，最高值（如果算上手续费还盈利）就卖。
     * 此时无非就是要找到两个点，买入日期，和卖出日期。
     *  1.买入日期：其实很好想，遇到更低点就记录一下。
     *  2.卖出日期：这个就不好算了，但也没有必要算出准确的卖出日期，
     *    只要当前价格大于（最低价格+手续费），就可以收获利润，至于准确的卖出日期，
     *    就是连续收获利润区间里的最后一天（并不需要计算是具体哪一天）。
     * 所以我们在做收获利润操作的时候其实有三种情况：
     *  情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），
     *  所以后面要继续收获利润。
     *  情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），今天要重新记录最小价格了。
     *  情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
     */
    public static int maxProfit(int[] prices, int fee) {
        int min = prices[0];
        int ans = 0;
        for (int i = 1;i < prices.length;i++){
            // 情况二：相当于买入
            if (prices[i] < min)min = prices[i];
            // 情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
            if (prices[i] > min && prices[i] <= (min + fee))continue;
            // 计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
            if (prices[i] > (min + fee)){
                ans += prices[i] - min - fee;
                // 相当于把(最高点-最低点)的操作分摊到多次相对的(最高点-最低点)的情形
                min = prices[i] - fee;// 情况一，这一步很关键
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices,2));
    }
}
