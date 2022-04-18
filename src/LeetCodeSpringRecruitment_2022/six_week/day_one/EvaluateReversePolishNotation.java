package LeetCodeSpringRecruitment_2022.six_week.day_one;

import java.util.Stack;

/**
 * @DATE 2022/4/18
 * @TIME 20:32
 * @Created by zhangzhi
 * @description LeetCode 150 题 逆波兰表达式求值
 * 逆波兰表达式主要有以下两个优点：
 *  去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 *  适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class EvaluateReversePolishNotation {

    public static int solution(String[] tokens){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                    case "+" -> stack.push(String.valueOf(num2 + num1));
                    case "-" -> stack.push(String.valueOf(num2 - num1));
                    case "/" -> stack.push(String.valueOf(num2 / num1));
                    case "*" -> stack.push(String.valueOf(num2 * num1));
                }
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution(tokens));
    }
}
