package LeetCodeRankWeek_2023._337_week;

// @date 2023/3/19
// @time 10:25
// @author zhangzhi
// @description

public class second {

    public static boolean checkValidGrid(int[][] grid) {
        int n = grid[0].length;
        return dfs(grid, n, 0, 0, 0);
    }
    private static boolean dfs(int[][] grid, int n, int i, int j, int num){
        if(num == n * n - 1){
            return true;
        }
        if(i + 1  < n && j + 2 < n && grid[i + 1][j + 2] == num + 1){
            if (dfs(grid, n, i + 1, j + 2, num + 1)) {
                return true;
            }
        }
        if(i - 1 >= 0 && j + 2 < n && grid[i - 1][j + 2] == num + 1){
            if (dfs(grid, n, i - 1, j + 2, num + 1)) {
                return true;
            }
        }
        if(i + 1 < n && j - 2 >= 0 && grid[i + 1][j - 2] == num + 1){
            if (dfs(grid, n,i + 1, j - 2, num + 1)) {
                return true;
            }
        }
        if(i - 1 >= 0 && j - 2 >= 0 && grid[i - 1][j - 2] == num + 1){
            if (dfs(grid, n, i - 1, j - 2, num + 1)) {
                return true;
            }
        }
        if(i - 2 >= 0 && j + 1 < n && grid[i - 2][j + 1] == num + 1){
            if (dfs(grid, n, i - 2, j + 1, num + 1)) {
                return true;
            }
        }
        if(i - 2 >= 0 && j - 1 >= 0 && grid[i - 2][j - 1] == num + 1){
            if (dfs(grid, n, i - 2, j - 1, num + 1)) {
                return true;
            }
        }
        if(i + 2 < n && j + 1 < n && grid[i + 2][j + 1] == num + 1){
            if (dfs(grid, n, i + 2, j + 1, num + 1)) {
                return true;
            }
        }
        if(i + 2 < n && j - 1 >= 0 && grid[i + 2][j - 1] == num + 1){
            if (dfs(grid, n, i + 2, j - 1, num + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,3,6},{5,8,1},{2,7,4}};
        System.out.println(checkValidGrid(grid));
    }
}
