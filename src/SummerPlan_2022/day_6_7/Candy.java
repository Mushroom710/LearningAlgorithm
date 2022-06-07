package SummerPlan_2022.day_6_7;

import java.util.Arrays;

/**
 * @DATE 2022/6/7
 * @TIME 18:00
 * @Created by zhangzhi
 * @description LeetCode 135 题 分发糖果
 * 这道题目一定是要确定一边之后，再确定另一边，
 * 例如比较每一个孩子的左边，然后再比较右边，
 * 如果两边一起考虑一定会顾此失彼 ！！！
 */
public class Candy {

    /**
     * @create zhangzhi
     * @date 2022/6/7
     * @time 18:25
     * @description 这就是两边一起考虑。。。只过了几个用例
     */
    public static int candy(int[] ratings) {
        if (ratings.length == 1)return 1;
        int[] count = new int[ratings.length];
        int sum = 0;
        if (ratings[0] > ratings[1]){
            count[0] = 2;
            count[1] = 1;
        }else if (ratings[0] < ratings[1]){
            count[0] = 1;
            count[1] = 2;
        }else {
            count[0] = 1;
            count[1] = 1;
        }
        sum += count[0] + count[1];
        int start = 1;
        int end = 2;
        for (;end < ratings.length;start++,end++){
            if (ratings[start] < ratings[end]){
                count[end] = count[start] + 1;
            }else {
                if (count[start] == 1){
                    count[end] = 1;
                }else {
                    count[end] = count[start] - 1;
                }
            }
            sum += count[end];
        }
        return sum;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/7
     * @time 18:25
     * @description
     * 1.初始时，每个人先发一个糖果
     * 2.先确定右边评分大于左边的情况（也就是从前向后遍历）
     * 此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，
     * 全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
     * 3.再确定左孩子大于右孩子的情况（从后向前遍历）
     * 如果 ratings[i] > ratings[i + 1]，此时 candyVec[i]（第i个小孩的糖果数量）就有两个选择了，
     * 一个是 candyVec[i + 1] + 1（从右边这个加 1 得到的糖果数量），比 i + 1 多一个
     * 一个是 candyVec[i]（之前比较右孩子大于左孩子得到的糖果数量）。不变
     * 所以就取 candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，
     * candyVec[i]只有取最大的才能既保持对左边 candyVec[i - 1] 的糖果多，
     * 也比右边 candyVec[i + 1] 的糖果多。
     */
    public static int right_solution(int[] ratings){
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i = 1; i < ratings.length;i++){
            if (ratings[i] > ratings[i - 1])candy[i] = candy[i - 1] + 1;
        }
        for (int i = ratings.length - 2;i >= 0;i--){
            if (ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i],candy[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length;i++){
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,3,2,2,1};
        System.out.println(candy(ratings));
        System.out.println(right_solution(ratings));
    }
}
