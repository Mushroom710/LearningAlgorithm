package AutumnPlan_2023.June.day_6_4;

// @date 2023/6/4
// @time 10:08
// @author zhangzhi
// @description LeetCode 518. 零钱兑换 II
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coins[i]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
