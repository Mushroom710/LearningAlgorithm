package AutumnPlan_2023.June.day_6_1;

// @date 2023/6/1
// @time 10:25
// @author zhangzhi
// @description LeetCode 784. 字母大小写全排列

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> ans;

    char[] schs;
    char[] path;

    private void dfs(int i){
        if(i == path.length){
            ans.add(new String(path));
            return;
        }
        char c = schs[i];

        path[i] = c;
        dfs(i + 1);

        if(c >= 'a' && c <= 'z'){
            c = (char)(c - 32);
            path[i] = c;
            dfs(i + 1);
            c = (char)(c + 32);
        }
        if(c >= 'A' && c <= 'Z'){
            c = (char)(c + 32);
            path[i] = c;
            dfs(i + 1);
            c = (char)(c - 32);
        }
    }

    public List<String> letterCasePermutation(String s) {
        this.schs = s.toCharArray();
        this.path = new char[s.length()];
        this.ans = new ArrayList<>();
        dfs(0);

        return ans;
    }
}
