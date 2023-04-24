package AutumnPlan_2023.April.day_4_24;

import java.util.Arrays;

// @date 2023/4/24
// @time 21:40
// @author zhangzhi
// @description LeetCode 322. 零钱兑换
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE / 2 ? -1 : dp[n][amount];
    }
}
