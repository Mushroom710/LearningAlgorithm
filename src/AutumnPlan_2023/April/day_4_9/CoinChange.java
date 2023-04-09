package AutumnPlan_2023.April.day_4_9;

// @date 2023/4/9
// @time 21:26
// @author zhangzhi
// @description LeetCode 322. 零钱兑换

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.min(dp[i][j] , dp[i + 1][j - coins[i]] + 1);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount] < Integer.MAX_VALUE / 2 ? dp[coins.length][amount] : -1;
    }
}
