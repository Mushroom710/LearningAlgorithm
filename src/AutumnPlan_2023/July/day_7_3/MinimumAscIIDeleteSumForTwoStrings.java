package AutumnPlan_2023.July.day_7_3;

// @date 2023/7/3
// @time 11:40
// @author zhangzhi
// @description LeetCode 712. 两个字符串的最小ASCII删除和
public class MinimumAscIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int j = 1; j <= m; j++){
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for(int i = 0; i < n; i++){
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
            for(int j = 0; j < m; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + s1.charAt(i), dp[i + 1][j] + s2.charAt(j));
                }
            }
        }
        return dp[n][m];
    }
}
