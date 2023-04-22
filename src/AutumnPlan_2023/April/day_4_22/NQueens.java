package AutumnPlan_2023.April.day_4_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/4/22
// @time 22:20
// @author zhangzhi
// @description LeetCode 51. N 皇后
public class NQueens {

    private int[] col;
    private List<List<String>> ans;
    private int n;
    private boolean[] onPath;
    private boolean[] diag1;
    private boolean[] diag2;

    private void dfs(int r){
        if(r == n){
            List<String> result = new ArrayList<>(4);
            for(int c : col){
                char[] board = new char[n];
                Arrays.fill(board, '.');
                board[c] = 'Q';
                result.add(new String(board));
            }
            ans.add(result);
        }

        for(int c = 0; c < n; c++){
            if(!onPath[c] && !diag1[r + c] && !diag2[r - c + n - 1]){
                onPath[c] = diag1[r + c] = diag2[r - c + n - 1] = true;
                col[r] = c;
                dfs(r + 1);
                onPath[c] = diag1[r + c] = diag2[r - c + n - 1] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.col = new int[n];
        this.ans = new ArrayList<>();
        this.n = n;
        this.onPath = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];

        dfs(0);

        return this.ans;
    }
}
