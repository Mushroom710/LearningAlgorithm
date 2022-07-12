package SummerPlan_2022.day_7_12;

import java.util.Arrays;

/**
 * @DATE 2022/7/12
 * @TIME 20:50
 * @Created by zhangzhi
 * @description LeetCode 115 题 不同的子序列
 */
public class DistinctSubsequences {

    // 1.确定dp数组（dp table）以及下标的含义
    //   dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
    // 2.确定递推公式
    //  这一类问题，基本是要分析两种情况
    //  s[i - 1] 与 t[j - 1]相等
    //  s[i - 1] 与 t[j - 1] 不相等
    //  当s[i - 1] 与 t[j - 1]相等时，dp[i][j]可以有两部分组成。
    //  一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
    //  一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
    // 例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，
    // 但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
    // 当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
    // 所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    // 当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，
    // 不用s[i - 1]来匹配，即：dp[i - 1][j]
    // 所以递推公式为：dp[i][j] = dp[i - 1][j];
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0;i <= s.length();i++){
            dp[i][0] = 1;
        }
        for (int i = 1;i <= s.length();i++){
            for (int j = 1;j <= t.length();j++){
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] nums : dp){
            System.out.println(Arrays.toString(nums));
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s,t));
    }
}
