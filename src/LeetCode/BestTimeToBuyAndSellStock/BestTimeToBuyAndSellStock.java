package LeetCode.BestTimeToBuyAndSellStock;

/**
 * @DATE 2022/3/4
 * @Created by zhangzhi
 * @description LeetCode121题买卖股票问题
 */
public class BestTimeToBuyAndSellStock{
    public static int solution(int[] prices){
        int min = prices[0];//记录默认最小值
        int max = 0;//记录利润
        for(int i = 0; i<prices.length;i++){
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
