package SummerPlan_2022.day_7_12;

/**
 * @DATE 2022/7/12
 * @TIME 21:24
 * @Created by zhangzhi
 * @description LeetCode 72 题 编辑距离
 */
public class EditDistance {

    // 1. 确定dp数组（dp table）以及下标的含义
    // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，
    // 最近编辑距离为dp[i][j]。
    // 2. 确定递推公式
    // 在确定递推公式的时候，首先要考虑清楚编辑的几种操作，整理如下：
    //  if (word1[i - 1] == word2[j - 1])
    //    不操作
    //  if (word1[i - 1] != word2[j - 1])
    //     增
    //     删
    //     换
    // a.if (word1[i - 1] == word2[j - 1]) 那么说明不用任何编辑，dp[i][j] 就应该是 dp[i - 1][j - 1]，
    // 即dp[i][j] = dp[i - 1][j - 1];
    // b.if (word1[i - 1] != word2[j - 1])，此时就需要编辑了，如何编辑呢？
    //  操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
    //  即 dp[i][j] = dp[i - 1][j] + 1;
    //  操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
    //  即 dp[i][j] = dp[i][j - 1] + 1;
    //  word2添加一个元素，相当于word1删除一个元素，例如 word1 = "ad" ，word2 = "a"，
    //  word1删除元素'd' 和 word2添加一个元素'd'，变成word1="a", word2="ad"， 最终的操作数是一样！
    //  操作三：替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增加元素，
    //  那么以下标i-2为结尾的word1 与 j-2为结尾的word2的最近编辑距离 加上一个替换元素的操作。
    //  即 dp[i][j] = dp[i - 1][j - 1] + 1;
    // 综上，当 if (word1[i - 1] != word2[j - 1]) 时取最小的，即：dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1;
    // 3. dp数组如何初始化
    // 再回顾一下dp[i][j]的定义：
    //  dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
    // 那么dp[i][0] 和 dp[0][j] 表示什么呢？
    // dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。
    // 那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，即：dp[i][0] = i;
    // 同理dp[0][j] = j;
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
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
}
