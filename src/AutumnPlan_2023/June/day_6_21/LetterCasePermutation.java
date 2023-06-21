package AutumnPlan_2023.June.day_6_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/21
// @time 10:53
// @author zhangzhi
// @description LeetCode 784. 字母大小写全排列
public class LetterCasePermutation {
    List<String> ans = new ArrayList<>();
    char[] path;

    private void dfs(int i){
        if(i == path.length){
            ans.add(new String(path));
            return;
        }

        dfs(i + 1);

        if(path[i] >= 'a' && path[i] <= 'z'){
            path[i] = (char)(path[i] - 32);
            dfs(i + 1);
            path[i] = (char)(path[i] + 32);
        }else if(path[i] >= 'A' && path[i] <= 'Z'){
            path[i] = (char)(path[i] + 32);
            dfs(i + 1);
            path[i] = (char)(path[i] - 32);
        }
    }

    public List<String> letterCasePermutation(String s) {
        this.path = s.toCharArray();
        dfs(0);
        return ans;
    }
}
