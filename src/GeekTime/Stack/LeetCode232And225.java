package GeekTime.Stack;

import java.util.Stack;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 * @description
 * 232.用栈实现队列
 *  思路：一个栈肯定不行，得用两个栈，一个栈做 input栈，一个做 output 栈
 *  一共需要实现三个方法：push/pop/peek
 *  push 时，使用 input 栈
 *  pop和 peek 时，使用 output 栈
 *      当 output 栈为空时，把input栈的元素放进去
 * 225.用队列实现栈
 */
public class LeetCode232And225 {
    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> output = new Stack<>();

    public static void stackpush(int val){
        input.push(val);
    }

    public static int stackpop(){
//        if(!output.isEmpty()){
//            System.out.println(output.pop());
//        }else{
//            while (!input.isEmpty()){
//                output.push(input.pop());
//            }
//            System.out.println(output.pop());
//        }
        //精简版，牛！！！
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return !output.isEmpty()?output.pop():0;
    }

    public static int stackpeek(){
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return !output.isEmpty()?output.peek():0;
    }

    public static void main(String[] args) {
        stackpush(1);
        stackpush(2);
        stackpush(3);
        System.out.println(stackpeek());
        System.out.println(stackpop());
        stackpush(4);
        stackpush(5);
        System.out.println(stackpop());
        System.out.println(stackpop());
        System.out.println(stackpop());
        System.out.println(stackpop());
    }
}
