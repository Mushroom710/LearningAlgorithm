package AutumnPlan_2023.June.day_6_1;

// @date 2023/6/1
// @time 9:51
// @author zhangzhi
// @description LeetCode 17. 电话号码的字母组合

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> ans;
    char[] path;
    String digits;

    private void dfs(int i){
        if(i == digits.length()){
            ans.add(new String(path));
            return;
        }
        int idx = Character.digit(digits.charAt(i), 10);
        for(int j = 0; j < map[idx].length(); j++){
            path[i] = map[idx].charAt(j);
            dfs(i + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.path = new char[this.digits.length()];
        this.ans = new ArrayList<>();
        dfs(0);
        return ans;
    }
}
