package AutumnPlan_2023.June.day_6_2;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/2
// @time 10:26
// @author zhangzhi
// @description LeetCode 22. 括号生成
public class GenerateParentheses {
    List<String> ans = new ArrayList<>();
    char[] path;
    int m;

    private void dfs(int i, int open){
        if(i == m){
            ans.add(new String(path));
        }
        if(open < m / 2){
            path[i] = '(';
            dfs(i + 1, open + 1);
        }
        if(i - open < open){
            path[i] = ')';
            dfs(i + 1, open);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.m = 2 * n;
        this.path = new char[m];
        dfs(0, 0);
        return ans;
    }
}
