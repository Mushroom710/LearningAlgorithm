package AutumnPlan_2023.June.day_6_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/6/26
// @time 11:35
// @author zhangzhi
// @description LeetCode 51. N 皇后
public class NQueens {
    List<List<String>> ans = new ArrayList<>();
    int[] cols;
    boolean[] boo;

    private boolean check(int r, int c){
        for(int R = 0; R < r; R++){
            int C = cols[R];
            if(r + c == R + C || r - c == R - C){
                return false;
            }
        }
        return true;
    }

    private void dfs(int r, int n){
        if(r == n){
            List<String> tmp = new ArrayList<>();
            for(int col : cols){
                char[] chs = new char[n];
                Arrays.fill(chs, '.');
                chs[col] = 'Q';
                tmp.add(new String(chs));
            }
            ans.add(tmp);
            return;
        }

        for(int j = 0; j < n; j++){
            if(!boo[j] && check(r, j)){
                boo[j] = true;
                cols[r] = j;
                dfs(r + 1, n);
                boo[j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.cols = new int[n];
        this.boo = new boolean[n];
        dfs(0, n);
        return ans;
    }
}
