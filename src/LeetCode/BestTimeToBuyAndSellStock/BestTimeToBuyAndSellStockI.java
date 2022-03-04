package LeetCode.BestTimeToBuyAndSellStock;

import java.util.Map;

/**
 * @DATE 2022/3/4
 * @Created by zhangzhi
 * @description LeetCode121 题
 */
public class BestTimeToBuyAndSellStockI {


    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/4
     * @time 20:15
     * description 买卖股票问题。只能买卖一次
     * 某天买入，在未来某天卖出
     * 所以：需要记录股票值最小的那天。
     * 然后在未来某天卖出
     * max = max(max,prices[i]-min)
     * min = min(min,prices[i])
     */
    public static int solution(int[] prices){
        int min = prices[0];//初始化最小值为第一天
        int max = 0;//记录利润
        for(int i = 0; i < prices.length; i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution(prices));
    }
}
