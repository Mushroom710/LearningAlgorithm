package AutumnPlan_2023.April.day_4_19;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/19
// @time 22:01
// @author zhangzhi
// @description LeetCode 784. 字母大小写全排列
public class LetterCasePermutation {

    private List<String> ans;
    private char[] chs;

    private void dfs(int i){
        ans.add(new String(chs));

        for(int j = i; j < chs.length; j++){
            if(chs[j] >= 'a' && chs[j] <= 'z'){
                chs[j] = (char)(chs[j] - 32);
                dfs(j + 1);
                chs[j] = (char)(chs[j] + 32);
            }
            if(chs[j] >= 'A' && chs[j] <= 'Z'){
                chs[j] = (char)(chs[j] + 32);
                dfs(j + 1);
                chs[j] = (char)(chs[j] - 32);
            }
        }
    }

    public List<String> letterCasePermutation(String s) {
        this.ans = new ArrayList<>();
        this.chs = s.toCharArray();
        dfs(0);
        return ans;
    }
}
