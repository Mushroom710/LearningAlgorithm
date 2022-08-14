package LeetCodeRankWeek._306_week;

// @DATE 2022/8/14
// @TIME 10:42
// @AUTHOR zhangzhi
// @DESCRIPTION

import java.util.Arrays;

public class first {

    private static int findMax(int i,int j,int[][] grid){
        int max = -1;
        for(int start = i;start <= i + 2;start++){
            for(int end = j;end <= j + 2;end++){
                max = Math.max(max,grid[start][end]);
            }
        }
        return max;
    }

    public static int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans.length; j++){
                ans[i][j] = findMax(i, j, grid);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        System.out.println(Arrays.deepToString(largestLocal(grid)));
    }
}
