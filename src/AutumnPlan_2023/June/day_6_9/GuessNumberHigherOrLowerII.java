package AutumnPlan_2023.June.day_6_9;

// @date 2023/6/9
// @time 18:11
// @author zhangzhi
// @description LeetCode 375. 猜数字大小 II
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j <= n; j++){
                int result = Integer.MAX_VALUE / 2;
                for(int k = i; k <= j; k++){
                    result = Math.min(result, Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
                dp[i][j] = result;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[1][n];
    }
}
