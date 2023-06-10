package AutumnPlan_2023.June.day_6_10;

// @date 2023/6/10
// @time 11:24
// @author zhangzhi
// @description LeetCode 1771. 由子序列构造的最长回文串的长度
public class MaximizePalindromeLengthFromSubsequences {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int w1 = word1.length();
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if(i < w1 && j >= w1){
                        ans = Math.max(ans, dp[i][j]);
                    }
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}
