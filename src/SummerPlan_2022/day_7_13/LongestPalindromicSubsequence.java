package SummerPlan_2022.day_7_13;

/**
 * @DATE 2022/7/13
 * @TIME 21:02
 * @Created by zhangzhi
 * @description LeetCode 516 题 最长回文子序列
 */
public class LongestPalindromicSubsequence {

    // 1.确定dp数组（dp table）以及下标的含义
    //   dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
    // 2.确定递推公式
    //   在判断回文子串的题目中，关键逻辑就是看s[i]与s[j]是否相同。
    //   如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
    //   如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入
    //   并不能增加[i,j]区间回文子串的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
    //   加入s[j]的回文子序列长度为dp[i + 1][j]。
    //   加入s[i]的回文子序列长度为dp[i][j - 1]。
    //   那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
    // 3.dp数组如何初始化
    //   首先要考虑当i 和j 相同的情况，从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2; 可以看出
    //   递推公式是计算不到 i 和j相同时候的情况。
    //   所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，
    //   即：一个字符的回文子序列长度就是1。
    // 4.确定遍历顺序
    //   从递推公式dp[i][j] = dp[i + 1][j - 1] + 2 和 dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
    //   可以看出，dp[i][j]是依赖于dp[i + 1][j - 1] 和 dp[i + 1][j]，
    //   也就是从矩阵的角度来说，dp[i][j] 下一行的数据。 所以遍历i的时候一定要从下到上遍历，
    //   这样才能保证，下一行的数据是经过计算的。
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0;i < s.length();i++)dp[i][i] = 1;

        for (int i = s.length() - 1;i>=0;i--){
            for (int j = i + 1;j < s.length();j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
