package AutumnPlan_2023.day_3_23;

// @date 2023/3/23
// @time 22:19
// @author zhangzhi
// @description LeetCode 150. 逆波兰表达式求值

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 + n1);
            }else if(tokens[i].equals("-")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            }else if(tokens[i].equals("*")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 * n1);
            }else if(tokens[i].equals("/")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
