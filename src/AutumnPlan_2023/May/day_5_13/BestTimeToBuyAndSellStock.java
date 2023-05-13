package AutumnPlan_2023.May.day_5_13;

// @date 2023/5/13
// @time 12:51
// @author zhangzhi
// @description LeetCode 121. 买卖股票的最佳时机
// 这题的贪心法很巧妙，给出了怎么通过一次遍历找出数组两个元素的最大差值。
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int price : prices){
            if(price < min){
                min = price;
            }else if(price - min > max){
                max = price - min;
            }
        }
        return max;
    }
}
