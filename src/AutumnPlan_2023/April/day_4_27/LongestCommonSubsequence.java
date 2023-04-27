package AutumnPlan_2023.April.day_4_27;

// @date 2023/4/27
// @time 15:51
// @author zhangzhi
// @description LeetCode 1143. 最长公共子序列
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int[][] dp = new int[2][text2.length() + 1];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                if(s[i] == t[j]){
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                }else{
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[text1.length() % 2][text2.length()];
    }
}
