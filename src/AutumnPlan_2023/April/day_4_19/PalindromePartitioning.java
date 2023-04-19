package AutumnPlan_2023.April.day_4_19;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/19
// @time 22:00
// @author zhangzhi
// @description LeetCode 131. 分割回文串
public class PalindromePartitioning {
    private List<List<String>> ans;
    private List<String> path;
    private String s;

    private boolean isPalindrome(int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
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
        // 枚举回文子串的结束位置
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(i, j)){
                path.add(s.substring(i, j + 1));
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
