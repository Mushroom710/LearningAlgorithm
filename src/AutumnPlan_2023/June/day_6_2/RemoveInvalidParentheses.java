package AutumnPlan_2023.June.day_6_2;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/2
// @time 10:00
// @author zhangzhi
// @description LeetCode 301. 删除无效的括号
public class RemoveInvalidParentheses {

    private StringBuilder sb;
    private List<String> ans;
    private char[] chs;
    private int len = 0;

    private void dfs(int i, int left, int right){
        if(i == chs.length){
            if(left == right){
                len = Math.max(sb.length(), len);
                String s = sb.toString();
                if(sb.length() >= len && !ans.contains(s)){
                    ans.add(s);
                }
            }
            return;
        }

        if(chs[i] >= 'a' && chs[i] <= 'z'){
            sb.append(chs[i]);
            dfs(i + 1, left, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(chs[i] == '('){
            sb.append(chs[i]);
            dfs(i + 1, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
            dfs(i + 1, left, right);
        }

        if(chs[i] == ')'){
            if(left > right){
                sb.append(chs[i]);
                dfs(i + 1, left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
                dfs(i + 1, left, right);
            }else{
                dfs(i + 1, left, right);
            }
        }

    }


    public List<String> removeInvalidParentheses(String s) {
        this.sb = new StringBuilder(25);
        this.ans = new ArrayList<>();
        this.chs = s.toCharArray();
        dfs(0, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
    }
}
