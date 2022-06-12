package LeetCodeRankWeek._297_week;

import java.util.Arrays;

/**
 * @DATE 2022/6/12
 * @TIME 11:04
 * @Created by zhangzhi
 * @description
 */
public class second {
    static int minPath = Integer.MAX_VALUE;
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        for (int y = 0;y < grid[0].length;y++){
            dfs(grid,moveCost,0,0,y);
        }
        return minPath;
    }

    public static void dfs(int[][] grid, int[][] moveCost,int path,int x,int y){
        if (x >= grid.length - 1){
            path += grid[x][y];
            minPath = Math.min(minPath,path);
            path -= grid[x][y];
            return ;
        }
        for (int j = 0; j < grid[0].length;j++){
            path += grid[x][y] + moveCost[grid[x][y]][j];
            dfs(grid,moveCost,path,x + 1,y);
            path -= grid[x][y] + moveCost[grid[x][y]][j];
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/6/12
     * @time 21:57
     * @description 想到了 DP，但是没想到怎么定义状态。。。
     * 功力还不够
     */
    public static int right_solution(int[][] grid, int[][] moveCost){
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int row = 0;row < n;row++){
            Arrays.fill(dp[row],Integer.MAX_VALUE);
        }
        for (int col = 0;col < m;col++){
            dp[0][col] = grid[0][col];
        }
        for (int row = 1;row < n;row++){
            for (int col = 0;col < m;col++){
                for (int m_col = 0;m_col < m;m_col++){
                    dp[row][col] = Math.min(dp[row - 1][m_col] + moveCost[grid[row - 1][m_col]][col] + grid[row][col],dp[row][col]);
                }
            }
        }
        for (int col = 0;col < m;col++){
            ans = Math.min(ans,dp[n - 1][col]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{5,3},{4,0},{2,1}};
        int[][] cost = new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(right_solution(grid,cost));
    }
}
