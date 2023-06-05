package AutumnPlan_2023.June.day_6_5;

// @date 2023/6/5
// @time 11:21
// @author zhangzhi
// @description LeetCode 712. 两个字符串的最小ASCII删除和
public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int sLen = s1.length();
        int tLen = s2.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int j = 0; j < tLen; j++){
            dp[0][j + 1] = dp[0][j] + t[j];
        }
        for(int i = 0; i < sLen; i++){
            dp[i + 1][0] = dp[i][0] + s[i];
            for(int j = 0; j < tLen; j++){
                if(s[i] == t[j]){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + s[i], dp[i + 1][j] + t[j]);
                }
            }
        }
        return dp[sLen][tLen];
    }
}
