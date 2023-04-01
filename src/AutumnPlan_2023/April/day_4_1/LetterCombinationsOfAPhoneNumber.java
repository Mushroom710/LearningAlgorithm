package AutumnPlan_2023.April.day_4_1;

// @date 2023/4/1
// @time 9:35
// @author zhangzhi
// @description

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private final String[] s = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> ans;
    private char[] path;
    private char[] digits;

    private void dfs(int i){
        if(i == digits.length){
            ans.add(new String(path));
            return;
        }
        char[] chs = s[digits[i] - '0'].toCharArray();
        for(char ch : chs){
            path[i] = ch;
            dfs(i + 1);

        }
    }

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        ans = new ArrayList<>();
        path = new char[len];



        this.digits = digits.toCharArray();
        if(len == 0){
            return ans;
        }
        dfs(0);
        return ans;
    }
}
