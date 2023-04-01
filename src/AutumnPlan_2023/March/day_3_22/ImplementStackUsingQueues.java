package AutumnPlan_2023.March.day_3_22;

// @date 2023/3/22
// @time 21:08
// @author zhangzhi
// @description LeetCode 225. 用队列实现栈
// 用两个队列实现，那么另外一个队列就是作为备份用的
// 其实用一个队列就可以实现

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        // 这个处理方法非常巧妙，可以避免我说的那种情况
        //每 offer 一个数（A）进来，都重新排列，把这个数（A）放到队列的队首
        public void push2(int x) {
            queue.offer(x);
            int size = queue.size();
            //移动除了 A 的其它数
            while (size-- > 1) {
                queue.offer(queue.poll());
            }
        }


        // 如果先调佣 top ，然后再调用 push
        // 需要特殊处理下：
        // top：5 1234
        // push：5 1234 6
        // 需要对 top 处理下
        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            int size = this.queue.size();
            while(size-- > 1){
                this.queue.add(this.queue.poll());
            }
            return this.queue.poll();
        }

        public int top() {
            int size = this.queue.size();
            while(size-- > 1){
                this.queue.add(this.queue.poll());
            }
            // 处理方法
            int num = this.queue.peek();
            this.queue.add(this.queue.poll());
            return num;
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

}
