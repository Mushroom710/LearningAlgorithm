package AutumnPlan_2023.April.day_4_8;

// @date 2023/4/8
// @time 22:15
// @author zhangzhi
// @description LeetCode 518. 零钱兑换 II

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coins[i]];
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[len][amount];
    }
}
