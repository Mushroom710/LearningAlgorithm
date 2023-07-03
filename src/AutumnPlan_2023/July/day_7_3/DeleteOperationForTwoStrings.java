package AutumnPlan_2023.July.day_7_3;

// @date 2023/7/3
// @time 11:39
// @author zhangzhi
// @description LeetCode 583. 两个字符串的删除操作
public class DeleteOperationForTwoStrings {
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
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
