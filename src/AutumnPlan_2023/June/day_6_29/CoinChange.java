package AutumnPlan_2023.June.day_6_29;

import java.util.Arrays;

// @date 2023/6/29
// @time 20:36
// @author zhangzhi
// @description LeetCode 322. 零钱兑换
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount] == Integer.MAX_VALUE / 2 ? -1 : dp[coins.length][amount];
    }
}
