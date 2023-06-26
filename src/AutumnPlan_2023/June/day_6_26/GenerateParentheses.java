package AutumnPlan_2023.June.day_6_26;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/26
// @time 11:33
// @author zhangzhi
// @description LeetCode 22. 括号生成
public class GenerateParentheses {
    List<String> ans = new ArrayList<>();
    char[] path;

    private void dfs(int i, int left, int n){
        if(i == 2 * n){
            ans.add(new String(path));
            return;
        }

        if(left < n){
            path[i] = '(';
            dfs(i + 1, left + 1, n);
        }
        if(i - left < left){
            path[i] = ')';
            dfs(i + 1, left, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.path = new char[2 * n];
        dfs(0, 0, n);
        return ans;
    }
}
