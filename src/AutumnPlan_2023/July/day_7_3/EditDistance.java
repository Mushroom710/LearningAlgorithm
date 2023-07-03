package AutumnPlan_2023.July.day_7_3;

// @date 2023/7/3
// @time 11:38
// @author zhangzhi
// @description LeetCode 72. 编辑距离
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 0; i < n; i++){
            dp[i + 1][0] = i + 1;
            for(int j = 0; j < m; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
