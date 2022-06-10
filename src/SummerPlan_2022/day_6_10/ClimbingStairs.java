package SummerPlan_2022.day_6_10;

import java.util.Arrays;

/**
 * @DATE 2022/6/10
 * @TIME 19:30
 * @Created by zhangzhi
 * @description LeetCode 70 题 爬楼梯
 * 多举几个例子，就可以发现其规律。
 * 对于 dp[0] ，题目的 n -> [1,45]
 * 根本没有 n 为 0 的情况，所以本题其实就不应该讨论 dp[0] 的初始化！
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n < 2)return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
