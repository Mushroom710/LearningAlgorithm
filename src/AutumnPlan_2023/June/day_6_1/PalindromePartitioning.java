package AutumnPlan_2023.June.day_6_1;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/1
// @time 10:07
// @author zhangzhi
// @description LeetCode 131. 分割回文串

public class PalindromePartitioning {

    List<List<String>> ans;
    List<String> path;
    String s;

    private boolean isP(int start, int end){
        for(;start <= end; start++, end--){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
        }
        return true;
    }

    private void dfs(int i){
        if(i == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isP(i, j)){
                String sub = s.substring(i, j + 1);
                path.add(sub);
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        this.s = s;
        dfs(0);

        return ans;
    }
}
