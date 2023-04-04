package AutumnPlan_2023.April.day_4_4;

// @date 2023/4/4
// @time 22:07
// @author zhangzhi
// @description LeetCode 63. 不同路径 II
// 和 62 题基本一致。多了一个障碍物的限制。

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
