package AutumnPlan_2023.June.day_6_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/21
// @time 10:51
// @author zhangzhi
// @description LeetCode 17. 电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    private String[] MAPPING = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    char[] path;
    int n;
    List<String> ans = new ArrayList<>();

    private void dfs(int i, String digits){
        if(i == n){
            ans.add(new String(path));
            return;
        }
        String s = MAPPING[digits.charAt(i) - '0'];
        for(int j = 0; j < s.length(); j++){
            path[i] = s.charAt(j);
            dfs(i + 1, digits);
        }

    }

    public List<String> letterCombinations(String digits) {
        this.n = digits.length();
        if(n == 0){
            return ans;
        }
        this.path = new char[this.n];
        dfs(0, digits);
        return ans;
    }
}
