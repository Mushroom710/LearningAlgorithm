package AutumnPlan_2023.June.day_6_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/21
// @time 10:52
// @author zhangzhi
// @description LeetCode 131. 分割回文串
public class PalindromePartitioning {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;

    private boolean isP(String sub){
        for(int i = 0, j = sub.length() - 1; i <= j; i++, j--){
            if(sub.charAt(i) != sub.charAt(j)){
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
            String sub = s.substring(i, j + 1);
            if(isP(sub)){
                path.add(sub);
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }
}
