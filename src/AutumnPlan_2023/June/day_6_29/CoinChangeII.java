package AutumnPlan_2023.June.day_6_29;

// @date 2023/6/29
// @time 20:37
// @author zhangzhi
// @description
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coins[i]];
                }
            }
        }
        return dp[n][amount];
    }
}
