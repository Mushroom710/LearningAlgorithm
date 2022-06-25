package SummerPlan_2022.day_6_25;

import java.util.Arrays;

/**
 * @DATE 2022/6/25
 * @TIME 18:03
 * @Created by zhangzhi
 * @description LeetCode 279 题 完全平方数
 * 解题思路和零钱交换是一致的，难点在与怎么描述平方！
 * i*i 是我没想到的。i*i 就解决了描述平方的问题！
 * dp[j] = min(dp[j - i * i] + 1,dp[j])
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1;i * i <= n;i++){// 遍历物品
            for (int j = 1;j <= n;j++){// 遍历背包
                if(j - i * i >= 0){
                    dp[j] = Math.min(dp[j - i * i] + 1,dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
