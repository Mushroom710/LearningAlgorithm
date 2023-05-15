package AutumnPlan_2023.May.day_5_15;

import java.util.Arrays;

// @date 2023/5/15
// @time 10:13
// @author zhangzhi
// @description LeetCode 375. 猜数字大小 II
public class GuessNumberHigherOrLowerII {
    private int[][] cache;

    private int dfs(int i, int j){
        if(i >= j){
            return 0;
        }
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            res = Math.min(res, Math.max(dfs(i, k-1) , dfs(k+1, j)) + k);
        }
        //System.out.println(res);
        return cache[i][j] = res;
    }

    public int getMoneyAmount(int n) {
        this.cache = new int[n + 1][n + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        return dfs(1, n);
    }
}
