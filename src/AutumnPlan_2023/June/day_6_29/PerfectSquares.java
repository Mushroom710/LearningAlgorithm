package AutumnPlan_2023.June.day_6_29;

import java.util.Arrays;

// @date 2023/6/29
// @time 20:37
// @author zhangzhi
// @description LeetCode 279. 完全平方数
public class PerfectSquares {
    public int numSquares(int n) {
        int x = (int)Math.sqrt(n);
        int[][] dp = new int[x + 2][n + 1];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= n; j++){
                if(j < i * i){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - i * i] + 1);
                }
            }
        }
        return dp[x + 1][n];
    }
}
