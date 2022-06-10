package SummerPlan_2022.day_6_10;

/**
 * @DATE 2022/6/10
 * @TIME 19:14
 * @Created by zhangzhi
 * @description LeetCode 505 题 斐波那契数
 * 动规五部曲：
 * 1.确定dp数组（dp table）以及下标的含义
 * 2.确定递推公式
 * 3.dp数组如何初始化
 * 4.确定遍历顺序
 * 5.举例推导dp数组
 */
public class FibonacciNumber {

    public static int fib(int n) {
        if (n < 2)return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
