package AutumnPlan_2023.April.day_4_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @date 2023/4/20
// @time 21:36
// @author zhangzhi
// @description LeetCode 2397. 被列覆盖的最多行数
public class MaximumRowsCoveredByColumns {
    private int[][] matrix;
    private List<Integer> cols;
    private Map<Integer, Integer> map;
    private int numSelect;
    private int ans;
    private int mcols;

    private void dfs(int i){
        if(cols.size() == numSelect){
            int hang = 0;
            for(int k = 0; k < matrix.length; k++){
                int one = 0;
                for(int col : cols){
                    if(matrix[k][col] == 1){
                        one++;
                    }
                }
                if(map.get(k) == one){
                    hang++;
                }
            }
            ans = Math.max(ans, hang);
        }
        if(i == mcols){
            return;
        }

        dfs(i + 1);

        cols.add(i);
        dfs(i + 1);
        cols.remove(cols.size() - 1);
    }

    public int maximumRows(int[][] matrix, int numSelect) {
        this.matrix = matrix;
        this.numSelect = numSelect;
        this.cols = new ArrayList<>(numSelect);
        this.ans = -1;
        this.mcols = matrix[0].length;
        this.map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            this.map.put(i, 0);
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    this.map.put(i, map.get(i) + 1);
                }
            }
        }
        dfs(0);
        return ans;
    }
}
