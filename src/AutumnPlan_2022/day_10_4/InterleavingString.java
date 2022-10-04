package AutumnPlan_2022.day_10_4;

// @date 2022/10/4
// @time 19:16
// @author zhangzhi
// @description LeetCode 97 题 交错字符串

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len + s2Len != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];

        dp[0][0] = true;
        for (int i = 0; i <= s1Len; i++){
            for (int j = 0; j <= s2Len; j++) {
                int p = i + j - 1;
                if(i > 0){
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(p));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[s1Len][s2Len];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcacc";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
