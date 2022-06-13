package SummerPlan_2022.day_6_13;

import java.util.Arrays;

/**
 * @DATE 2022/6/13
 * @TIME 17:13
 * @Created by zhangzhi
 * @description LeetCode 62 题 不同路径
 * 题目的递归公式很明确，只要确定好初始化和遍历顺序即可
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);
        for (int row = 0;row < m;row++){
            dp[row][0] = 1;
        }

        for (int row = 1;row < m;row++){
            for (int col = 1;col < n;col++){
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
