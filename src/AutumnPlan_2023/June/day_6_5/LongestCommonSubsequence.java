package AutumnPlan_2023.June.day_6_5;

// @date 2023/6/5
// @time 11:20
// @author zhangzhi
// @description LeetCode 1143. 最长公共子序列
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int sLen = text1.length();
        int tLen = text2.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int i = 0; i < sLen; i++){
            for(int j = 0; j < tLen; j++){
                if(s[i] == t[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[sLen][tLen];
    }
}
