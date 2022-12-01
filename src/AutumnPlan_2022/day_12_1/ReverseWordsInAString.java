package AutumnPlan_2022.day_12_1;

// @date 2022/12/1
// @time 21:12
// @author zhangzhi
// @description LeetCode 151.翻转字符串里的单词

import java.util.Stack;

public class ReverseWordsInAString {

    private static String subString(String s, int start, int end){
        char[] chs = new char[end - start + 1];
        for(int i = 0; i < chs.length; i++){
            chs[i] = s.charAt(start++);
        }
        return new String(chs);
    }

    /**
     * 用栈来保存分割出来的单词！栈是后进先出，符合题意。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length();){
            if(s.charAt(i) != ' '){
                for(int j = i; j < s.length(); j++){
                    if(j == s.length() - 1 && s.charAt(j) != ' '){
                        stack.push(subString(s,i,j));
                        i = j + 1;
                        break;
                    }else if(s.charAt(j) == ' '){
                        stack.push(subString(s,i,j - 1));
                        i = j;
                        break;
                    }
                }
            }else{
                i++;
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(stack.pop());
        while(!stack.isEmpty()){
            ans.append(" ").append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
}
