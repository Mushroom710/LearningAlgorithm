package LeetCodeSpringRecruitment_2022.second_week.day_two;

/**
 * @DATE 2022/3/22
 * @TIME 14:29
 * @Created by zhangzhi
 * @description LeetCode 64 题 最小路径和
 * 每一次只能向下或向右走一步
 * 1.状态定义：
 *      dp[i][j]: 到这个位置的最小路径和
 * 2.递推方程：
 *      dp[i][j] = grid[i][j] + min(dp[i-1][j],dp[i][j-1])
 * 3.初始化：
 *      dp[0][0] = grid[0][0]
 *      a.第一行初始化
 *      dp[0][j] = grid[0][j] + dp[0][j-1]
 *      b.第一列初始化
 *      dp[i][0] = grid[i][0] + dp[i-1][0]
 */
public class MinimumPathSum {

    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 14:39
     * @description 中等的动态规划问题
     */
    public static int solution(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // DP 数组的初始化
        dp[0][0] = grid[0][0];
        for(int row = 1; row < m; row++){
            dp[row][0] = grid[row][0] + dp[row-1][0];
        }
        for(int col = 1; col < n; col++){
            dp[0][col] = grid[0][col] + dp[0][col-1];
        }
        // 计算 DP 数组的最小路径和
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                dp[row][col] = grid[row][col] + Math.min(dp[row-1][col],dp[row][col-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution(grid));
    }
}
