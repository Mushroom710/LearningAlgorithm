package LeetCodeSpringRecruitment_2022.five_week.day_three;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @DATE 2022/4/13
 * @TIME 21:47
 * @Created by zhangzhi
 * @description LeetCode 225 题 用队列实现栈
 * 每次调用 pop 和 top 都保证栈不为空
 */

// 用两个队列实现
class MyStack_Queue {

    Queue<Integer> que1;
    Queue<Integer> que2; // 辅助队列，用来备份

    public MyStack_Queue() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public void push(int x) {
        que1.offer(x);
    }

    public int pop() {
        int size = que1.size();
        while (size-- > 1){
            que2.offer(que1.poll());
        }
        Queue<Integer> temp = que1;
        que1 = que2;
        que2 = temp;
        return que2.poll();
    }

    public int top() {
        int ans = pop();
        que1.offer(ans);
        return ans;
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}

/**
 * @create zhangzhi
 * @date 2022/4/13
 * @time 21:59
 * @description 使用 双端队列，直接在队尾完成入栈和出栈操作
 */
class MyStack_Dequeue{

    Deque<Integer> deque;

    public MyStack_Dequeue() {
        deque = new ArrayDeque<>();
    }

    // 队尾入栈
    public void push(int x) {
        deque.addLast(x);
    }

    // 队尾出栈
    public int pop() {
        return deque.removeLast();
    }

    // 队尾元素
    public int top() {
        return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack_Queue que = new MyStack_Queue();
        MyStack_Dequeue deq = new MyStack_Dequeue();
    }
}
