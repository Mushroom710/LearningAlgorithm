package AutumnPlan_2023.June.day_6_5;

// @date 2023/6/5
// @time 11:21
// @author zhangzhi
// @description LeetCode 583. 两个字符串的删除操作
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int sLen = word1.length();
        int tLen = word2.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int j = 0; j < tLen; j++){
            dp[0][j + 1] = j + 1;
        }
        for(int i = 0; i < sLen; i++){
            dp[i + 1][0] = i + 1;
            for(int j = 0; j < tLen; j++){
                if(s[i] == t[j]){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[sLen][tLen];
    }
}
