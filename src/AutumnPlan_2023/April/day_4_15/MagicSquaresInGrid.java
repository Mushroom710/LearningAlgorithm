package AutumnPlan_2023.April.day_4_15;

// @date 2023/4/15
// @time 9:53
// @author zhangzhi
// @description

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MagicSquaresInGrid {

    /**
     * 卡了最后一个用例
     * 而且忘记了 1-9 之和为 45 。。。
     */
    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] nums = grid;
        int ans = 0;
        for(int i = 0; i < row - 2; i++){
            for(int j = 0; j < col - 2; j++){
                Map<Integer, Integer> map = new HashMap<>();
                Set<Integer> set = new HashSet<>();
                boolean flag = false;
                for(int m = i; m < i + 3 && !flag; m++){
                    for(int k = j; k < j + 3; k++){
                        if(nums[m][k] < 1 || nums[m][k] > 9 || set.contains(nums[m][k])){
                            flag = true;
                            break;
                        }
                        set.add(nums[m][k]);
                    }
                }
                if(flag){
                    continue;
                }
                int sum = nums[i][j] + nums[i][j + 1] + nums[i][j + 2];
                if(sum != nums[i][j] + nums[i][j + 1] + nums[i][j + 2]){
                    break;
                }
                if(sum != nums[i + 1][j] + nums[i + 1][j + 1] + nums[i + 1][j + 2]){
                    break;
                }
                if(sum != nums[i + 2][j] + nums[i + 2][j + 1] + nums[i + 2][j + 2]){
                    break;
                }
                if(sum != nums[i][j] + nums[i + 1][j] + nums[i + 2][j]){
                    break;
                }
                if(sum != nums[i][j + 1] + nums[i + 1][j + 1] + nums[i + 2][j + 1]){
                    break;
                }
                if(sum != nums[i][j + 2] + nums[i + 1][j + 2] + nums[i + 2][j + 2]){
                    break;
                }
                if(sum != nums[i][j] + nums[i + 1][j + 1] + nums[i + 2][j + 2]){
                    break;
                }
                if(sum != nums[i][j + 2] + nums[i + 1][j + 1] + nums[i + 2][j]){
                    break;
                }
                ans += 1;
            }
        }
        return ans;
    }

    // 这写的是真优雅
    public static int numMagicSquaresInside2(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R-2; ++r) {
            for (int c = 0; c < C-2; ++c) {
                if (grid[r+1][c+1] != 5) {
                    continue;  // optional skip
                }
                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                        grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                        grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v: vals) {
            count[v]++;
        }
        for (int v = 1; v <= 9; ++v) {
            if (count[v] != 1) {
                return false;
            }
        }

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{10,3,5},{1,6,11},{7,9,2}};
        System.out.println(numMagicSquaresInside2(grid));
    }
}
