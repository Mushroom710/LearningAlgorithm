package AutumnPlan_2023.April.day_4_27;

import java.util.Arrays;

// @date 2023/4/27
// @time 20:30
// @author zhangzhi
// @description LeetCode 712. 两个字符串的最小ASCII删除和
public class MinimumASCIIDeleteSumForTwoStrings {

    private char[] s;
    private char[] t;
    private int[][] cache;

    private int dfs(int i, int j){
        if(i < 0){
            int sum = 0;
            while(j >= 0){
                sum += t[j--];
            }
            return sum;
        }
        if(j < 0){
            int sum = 0;
            while(i >= 0){
                sum += s[i--];
            }
            return sum;
        }

        if(cache[i][j] != -1){
            return cache[i][j];
        }

        if(s[i] == t[j]){
            return cache[i][j] = dfs(i - 1, j - 1);
        }
        return cache[i][j] = Math.min(dfs(i - 1, j) + s[i], dfs(i, j - 1) + t[j]);
    }

    public int minimumDeleteSum(String s1, String s2) {
        this.s = s1.toCharArray();
        this.t = s2.toCharArray();
        this.cache = new int[s1.length() + 1][s2.length() + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }

        return dfs(s1.length() - 1, s2.length() - 1);
    }
}
