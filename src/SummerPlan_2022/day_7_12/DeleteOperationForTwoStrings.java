package SummerPlan_2022.day_7_12;

/**
 * @DATE 2022/7/12
 * @TIME 21:03
 * @Created by zhangzhi
 * @description LeetCode 583 题 两个字符串的删除操作
 */
public class DeleteOperationForTwoStrings {

    // 1.确定dp数组（dp table）以及下标的含义
    //  dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，
    //  想要达到相等，所需要删除元素的最少次数。
    // 2.确定递推公式
    //  当word1[i - 1] 与 word2[j - 1]相同的时候
    //  当word1[i - 1] 与 word2[j - 1]不相同的时候
    //  当word1[i - 1] 与 word2[j - 1]相同的时候，dp[i][j] = dp[i - 1][j - 1];
    //  当word1[i - 1] 与 word2[j - 1]不相同的时候，有三种情况：
    //  情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
    //  情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
    //  情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
    //  那最后当然是取最小值，所以当word1[i - 1] 与 word2[j - 1]不相同的时候，
    //  递推公式：dp[i][j] = min({dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1, dp[i][j - 1] + 1});
    // 3.dp数组如何初始化
    //  从递推公式中，可以看出来，dp[i][0] 和 dp[0][j]是一定要初始化的。
    //  dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，
    //  才能和word2相同呢，很明显dp[i][0] = i。
    //  dp[0][j]的话同理
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0;i <= word1.length();i++){
            dp[i][0] = i;
        }
        for (int j = 0;j <= word2.length();j++){
            dp[0][j] = j;
        }
        for (int i = 1;i <= word1.length();i++){
            for (int j = 1;j <= word2.length();j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // 本题和动态规划：1143.最长公共子序列 (opens new window)基本相同，
    // 只要求出两个字符串的最长公共子序列长度即可，
    // 那么除了最长公共子序列之外的字符都是必须删除的，
    // 最后用两个字符串的总长度减去两个最长公共子序列的长度就是删除的最少步数。
    public static int minDistance_1143(String word1,String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1;i <= word1.length();i++){
            for (int j = 1;j <= word2.length();j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
        System.out.println(minDistance_1143(word1,word2));
    }
}
