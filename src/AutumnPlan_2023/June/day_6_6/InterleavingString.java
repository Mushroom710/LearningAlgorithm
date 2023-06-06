package AutumnPlan_2023.June.day_6_6;

// @date 2023/6/6
// @time 10:27
// @author zhangzhi
// @description LeetCode 97. 交错字符串
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;
        for(int i = 0; i < s1Len; i++){
            dp[i + 1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for(int j = 0; j < s2Len; j++){
            dp[0][j + 1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
        }
        for(int i = 0; i < s1Len; i++){
            for(int j = 0; j < s2Len; j++){
                dp[i + 1][j + 1] = (s1.charAt(i)==s3.charAt(i+j+1)&&dp[i][j+1])||(s2.charAt(j)==s3.charAt(i+j+1)&&dp[i+1][j]);
            }
        }
        return dp[s1Len][s2Len];
    }
}
