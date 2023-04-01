package AutumnPlan_2023.March.day_3_22;

// @date 2023/3/22
// @time 20:53
// @author zhangzhi
// @description LeetCode 232. 用栈实现队列

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {

        // 出队栈
        Stack<Integer> out;
        // 入队栈
        Stack<Integer> in;

        public MyQueue() {
            this.out = new Stack<>();
            this.in = new Stack<>();
        }

        public void push(int x) {
            // 先把出队栈的元素全部放入入队栈
            if(!out.isEmpty()){
                while(!out.isEmpty()){
                    in.push(out.pop());
                }
            }
            in.push(x);
        }

        public int pop() {
            // 先把入队栈的元素全部放入出队栈
            if(!in.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            // 先把入队栈的元素全部放入出队栈
            if(!in.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }

}
