package SummerPlan_2022.day_6_13;

import java.util.Arrays;

/**
 * @DATE 2022/6/13
 * @TIME 17:22
 * @Created by zhangzhi
 * @description LeetCode 63 题 不同路径 II
 * 这题在前一题的基础上加上了障碍物
 * 那么，对应障碍物，到达的方法就是 0 ，dp[i][j] = 0
 */
public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < n;i++){
            // 遇到障碍物，那么后面的位置就是不可达，直接 break，就是 0
            if (obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0;i < m;i++){
            // 遇到障碍物，那么后面的位置就是不可达，直接 break，就是 0
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] ob = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(ob));
    }
}
