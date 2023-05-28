package LeetCodeRankWeek_2023._347_week;

import java.util.HashSet;
import java.util.Set;

// @date 2023/5/28
// @time 10:21
// @author zhangzhi
// @description
public class second {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Set<Integer> top = new HashSet<>();
                for(int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--){
                    top.add(grid[r][c]);
                }
                Set<Integer> bottom = new HashSet<>();
                for(int r = i + 1, c = j + 1; r < m && c < n; r++, c++){
                    bottom.add(grid[r][c]);
                }
                ans[i][j] = Math.abs(top.size() - bottom.size());
            }
        }
        return ans;
    }
}
