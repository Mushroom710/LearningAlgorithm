package AutumnPlan_2023.June.day_6_10;

// @date 2023/6/10
// @time 11:23
// @author zhangzhi
// @description LeetCode 1312. 让字符串成为回文串的最少插入次数
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(i >= j){
                    dp[i][j] = 0;
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }
}
