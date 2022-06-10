package SummerPlan_2022.day_6_10;

/**
 * @DATE 2022/6/10
 * @TIME 20:21
 * @Created by zhangzhi
 * @description LeetCode 5 题 最长回文子串
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() < 2)return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int i = 0;i < len;i++){
            dp[i][0] = true;
        }
        for (int L = 2; L <= len;L++){
            for (int i = 0;i < len;i++){
                int j = L + i - 1;
                if (j >= len){
                    continue;
                }
                if (chs[i] != chs[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
