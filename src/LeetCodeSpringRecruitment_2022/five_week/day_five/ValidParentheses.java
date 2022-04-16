package LeetCodeSpringRecruitment_2022.five_week.day_five;

import java.util.Stack;

/**
 * @DATE 2022/4/15
 * @TIME 21:33
 * @Created by zhangzhi
 * @description LeetCode 20 有效的括号
 * 思路：
 *  分析清楚有哪几种不匹配的情况
 *   a.左括号多余
 *   b.括号没有多余，但是类型不匹配
 *   c.右括号多余
 *  小技巧：
 *   在入栈的时候，用左括号的对应的右括号入栈，然后再匹配时，就可以直接比较栈顶元素是否相等即可
 */
public class ValidParentheses {

    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            // 左括号入栈
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
                // 对应于 b 和 c 两种情况
            }else if (stack.isEmpty() || stack.peek() != s.charAt(i)){
                return false;
            }else {
                // 若匹配上，就弹出栈顶元素
                stack.pop();
            }
        }
        // 对应于 a 情况。如果栈为空，说明全部匹配，否则说明左括号多余
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}]";
        System.out.println(solution(s));
    }
}
