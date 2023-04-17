package AutumnPlan_2023.April.day_4_17;

// @date 2023/4/17
// @time 21:58
// @author zhangzhi
// @description LeetCode 1143. 最长公共子序列
// 最长公共子序列可以不连续
// 所以考察 s[i] 和 t[j]：
// 有：选或不选两种情况
// 都选，都不选，选s，选t
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];
    }
}
