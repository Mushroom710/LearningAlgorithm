package LeetCodeSpringRecruitment_2022.five_week.day_three;

import java.util.Stack;

/**
 * @DATE 2022/4/13
 * @TIME 21:28
 * @Created by zhangzhi
 * @description LeetCode 232 题 用栈实现队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */

class MyQueue {

    Stack<Integer> stackIn; // 负责入栈
    Stack<Integer> stackOut; // 负责出栈

    // 队列初始化
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 入队
    public void push(int x) {
        stackIn.push(x);
    }

    // 出队
    public int pop() {
        // 如果 stackOut 是空，那么就需要把 stackIn的元素全部放入 stackOut 中
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    // 获取队列头部元素。
    // 这个是可以复用 pop 方法的
    public int peek() {
        int res = pop();
        stackOut.push(res);
        return res;
    }

    // 判断队列是否为空，需要判断两个栈是否为空
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        q.pop();
        q.push(4);
        q.push(5);
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
