package AutumnPlan_2023.April.day_4_4;

// @date 2023/4/4
// @time 21:09
// @author zhangzhi
// @description LeetCode 62. 不同路径

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,7));
    }
}
