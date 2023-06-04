package AutumnPlan_2023.June.day_6_4;

import java.util.Arrays;

// @date 2023/6/4
// @time 10:08
// @author zhangzhi
// @description LeetCode 279. 完全平方数
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
