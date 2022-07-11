package SummerPlan_2022.day_7_11;

/**
 * @DATE 2022/7/11
 * @TIME 21:11
 * @Created by zhangzhi
 * @description LeetCode 1143 题 最长公共子序列
 */
public class LongestCommonSubsequence {

    // 1.确定dp数组（dp table）以及下标的含义
    //   dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
    // 2.确定递推公式
    //  主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
    //  如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，
    //  所以dp[i][j] = dp[i - 1][j - 1] + 1;
    //  如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与
    //  text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，
    //  取最大的。
    //  即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1;i <= text1.length();i++){
            for (int j = 1;j <= text2.length();j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
