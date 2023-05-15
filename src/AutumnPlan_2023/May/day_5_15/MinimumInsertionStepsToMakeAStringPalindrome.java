package AutumnPlan_2023.May.day_5_15;

import java.util.Arrays;

// @date 2023/5/15
// @time 10:32
// @author zhangzhi
// @description
public class MinimumInsertionStepsToMakeAStringPalindrome {
    private char[] t;
    private int[][] cache;

    private int dfs(int i, int j){
        if(i >= j){
            return 0;
        }
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if(t[i] == t[j]){
            return cache[i][j] = dfs(i + 1, j - 1);
        }
        return cache[i][j] = Math.min(dfs(i + 1, j), dfs(i, j - 1)) + 1;
    }

    public int minInsertions(String s) {
        this.t = s.toCharArray();
        this.cache = new int[s.length() + 1][s.length() + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        return dfs(0, s.length() - 1);
    }
}
