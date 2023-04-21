package AutumnPlan_2023.April.day_4_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/21
// @time 9:49
// @author zhangzhi
// @description LeetCode 22. 括号生成
public class GenerateParentheses {
    private int n;
    private int m;
    private char[] path;
    private List<String> ans;

    private void dfs(int i, int leftOpen){
        if(i == m){
            ans.add(new String(path));
            return;
        }

        if(leftOpen < n){
            path[i] = '(';
            dfs(i + 1, leftOpen + 1);
        }

        if(i - leftOpen < leftOpen){
            path[i] = ')';
            dfs(i + 1, leftOpen);
        }
    }


    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.m = 2 * n;
        this.path = new char[m];
        this.ans = new ArrayList<>();
        dfs(0, 0);
        return ans;
    }
}
