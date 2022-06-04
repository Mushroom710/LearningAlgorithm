package SummerPlan_2022.day_6_4;

/**
 * @DATE 2022/6/4
 * @TIME 19:42
 * @Created by zhangzhi
 * @description LeetCode 122 题 买卖股票的最佳时机 II
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * @create zhangzhi
     * @date 2022/6/4
     * @time 19:46
     * @description
     * 可以这么做是因为一支股票可以多次买卖
     *
     * 如果想到其实最终利润是可以分解的，那么本题就很容易了！
     * 如何分解呢？
     * 假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
     * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
     * 此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
     * 收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1;i < prices.length;i++){
            profit += Math.max(prices[i] - prices[i - 1],0);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
