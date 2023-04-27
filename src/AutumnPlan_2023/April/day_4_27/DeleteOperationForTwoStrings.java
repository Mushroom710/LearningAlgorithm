package AutumnPlan_2023.April.day_4_27;

import java.util.Arrays;

// @date 2023/4/27
// @time 20:07
// @author zhangzhi
// @description LeetCode 583. 两个字符串的删除操作
public class DeleteOperationForTwoStrings {

    private char[] s;
    private char[] t;
    private int[][] cache;

    private int dfs(int i, int j){
        if(i < 0){
            return j + 1;
        }
        if(j < 0){
            return i + 1;
        }

        if(cache[i][j] != -1){
            return cache[i][j];
        }

        if(s[i] == t[j]){
            return cache[i][j] = dfs(i - 1, j - 1);
        }
        return cache[i][j] = Math.min(dfs(i, j - 1), dfs(i - 1, j)) + 1;
    }

    public int minDistance(String word1, String word2) {
        this.s = word1.toCharArray();
        this.t = word2.toCharArray();
        this.cache = new int[word1.length() + 1][word2.length() + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }

        return dfs(word1.length() - 1, word2.length() - 1);
    }
}
