package GeekTime.Stack;

import java.util.Stack;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 */
public class ParenthesesMatching {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/26
     * @time 10:09
    * @description 括号匹配问题
     */
    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(!stack.isEmpty()&&stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                    return false;
                case ']':
                    if(!stack.isEmpty()&&stack.peek() == '['){
                        stack.pop();
                        break;
                    }
                    return false;
                case '}':
                    if(!stack.isEmpty()&&stack.peek() == '{'){
                        stack.pop();
                        break;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")";
        System.out.println(solution(s));
    }
}
