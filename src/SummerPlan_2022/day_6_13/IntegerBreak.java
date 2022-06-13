package SummerPlan_2022.day_6_13;

/**
 * @DATE 2022/6/13
 * @TIME 17:52
 * @Created by zhangzhi
 * @description LeetCode 343 题 整数拆分
 * 1.确定dp数组（dp table）以及下标的含义
 *  dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
 * dp[i]的定义讲贯彻整个解题过程，下面哪一步想不懂了，就想想dp[i]究竟表示的是啥！
 * 2.确定递推公式
 *  可以想 dp[i]最大乘积是怎么得到的呢？
 *  其实可以从1遍历j，然后有两种渠道得到dp[i].
 *  一个是j * (i - j) 直接相乘。
 *  一个是j * dp[i - j]，相当于是拆分(i - j)，对这个拆分不理解的话，可以回想dp数组的定义。
 *  j是从 1开始遍历，拆分j的情况，在遍历j的过程中其实都计算过了。那么从 1遍历j，
 *  比较 (i - j) * j和 dp[i - j] * j 取最大的。
 *  递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
 *  也可以这么理解，j * (i - j) 是单纯的把整数拆分为两个数相乘，
 *  而 j * dp[i - j] 是拆分成两个以及两个以上的个数相乘。
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3;i <= n;i++){
            for (int j = 1; j <= i - j; j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
