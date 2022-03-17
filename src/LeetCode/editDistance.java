package LeetCode;

import java.util.Arrays;

/**
 * @DATE 2022/3/17
 * @TIME 10:02
 * @Created by zhangzhi
 * @description LeetCode 72 题 编辑距离
 * 1.暴力求解 不会写
 * 2.DP
 *  a.状态定义：dp[i][j]
 *  解释：i 表示 word1 的字符位
 *       j 表示 word2 的字符位
 *  dp[i][j] 表示 word1 的前 i 个字符 变换到 word2 的前 j 个字符的最小步数
 *  result = dp[m][n]
 *  b.DP方程
 *  dp[i][j]:
 *      if w1[i] == w2[j]: //不需要做任何操作
 *          dp[i-1][j-1]
 *      else: // Insert/Delete/Replace
 *          1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
 *      dp[i-1][j]：在 word1 中 Insert 一个字符
 *      dp[i][j-1]：在 word2 中 Delete 一个字符
 *      dp[i-1][j-1]：word1 和 word2 替换为相同的字符
 */

/**
 * @create zhangzhi
 * @date 2022/3/17
 * @time 19:47
 * @description LeetCode的官方题解
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}

public class editDistance {

    public static int solution(String word1,String word2){
        int n = word1.length();
        int m = word2.length();
        if(n * m == 0){
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0;i < n + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 0;j < m + 1; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i< n+1; i++){
            for(int j = 1; j< m+1; j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down += 1;
                }
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(solution("distance","springbok"));
        System.out.println(new Solution().minDistance("distance","springbok"));
    }
}
