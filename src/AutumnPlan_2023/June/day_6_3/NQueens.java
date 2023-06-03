package AutumnPlan_2023.June.day_6_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/6/3
// @time 11:18
// @author zhangzhi
// @description LeetCode 51. N 皇后
public class NQueens {
    List<List<String>> ans = new ArrayList<>();
    int[] col;
    boolean[] inCol;

    private boolean valid(int r, int c){
        for(int R = 0; R < r; R++){
            int C = col[R];
            if(r + c == R + C || r - c == R - C){
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, int n){
        if(i == n){
            List<String> tmp = new ArrayList<>();
            for(int c : col){
                char[] board = new char[n];
                Arrays.fill(board, '.');
                board[c] = 'Q';
                tmp.add(new String(board));
            }
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int c = 0; c < n; c++){
            if(!inCol[c] && valid(i, c)){
                inCol[c] = true;
                col[i] = c;
                dfs(i + 1, n);
                inCol[c] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.col = new int[n];
        this.inCol = new boolean[n];
        dfs(0, n);
        return ans;
    }
}
