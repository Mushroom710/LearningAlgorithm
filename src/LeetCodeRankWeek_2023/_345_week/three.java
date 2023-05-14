package LeetCodeRankWeek_2023._345_week;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

// @date 2023/5/14
// @time 11:48
// @author zhangzhi
// @description
public class three {

    // BFS。本质上就是看能不能从第一列走到第二列，如果可以，就把行号入队。
    // 如果队列为空，说明走不到下一列了，直接返回。注意，这里只需要遍历到n-1列即可。
    // 如果遍历到n-1列，队列不为空，那就直接返回n-1
    // 注意去重。
    public int maxMoves(int[][] grid) {
        Deque<Integer> deque = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            deque.add(i);
        }
        int[] vis = new int[col];
        Arrays.fill(vis, -1);
        for(int c = 0; c < col - 1; c++){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                int k = deque.pop();
                for(int r = Math.max(k - 1, 0); r < Math.min(k + 2, row); r++){
                    if(vis[r] != c + 1 && grid[k][c] < grid[c][c + 1]){
                        vis[r] = c + 1;
                        deque.add(r);
                    }
                }
            }
            if(deque.isEmpty()){
                return c;
            }
        }
        return col - 1;
    }



    // 记忆化搜索 -- 动态规划
    private int[][] grid;
    private int[][] cache;

    private int dfs(int i, int j){
        if(j == grid[0].length - 1){
            return 0;
        }
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        int res = 0;
        for(int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++){
            if(grid[i][j] < grid[k][j + 1]){
                res = Math.max(res, dfs(k, j + 1) + 1);
            }
        }
        return cache[i][j] = res;
    }

    public int maxMoves2(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        this.cache = new int[grid.length + 1][grid[0].length + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        for(int i = 0; i < grid.length; i++){
            ans = Math.max(ans, dfs(i, 0));
        }
        return ans;
    }
}
