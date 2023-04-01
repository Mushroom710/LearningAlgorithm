package AutumnPlan_2023.March.day_3_22;

// @date 2023/3/22
// @time 21:24
// @author zhangzhi
// @description LeetCode 20. 有效的括号
// 代码之前要分析好有哪几种不匹配的情况，如果不在动手之前分析好，写出的代码也会有很多问题。

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
                continue;
            }else if(s.charAt(i) == '['){
                stack.push(']');
                continue;
            }else if(s.charAt(i) == '{'){
                stack.push('}');
                continue;
            }
            // stack.isEmpty() 是用于检测 这种 "}}}}" 类型的测试用例。
            if(stack.isEmpty() || stack.peek() != s.charAt(i)){
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
