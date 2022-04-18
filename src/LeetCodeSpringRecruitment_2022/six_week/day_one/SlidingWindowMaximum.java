package LeetCodeSpringRecruitment_2022.six_week.day_one;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @DATE 2022/4/18
 * @TIME 21:02
 * @Created by zhangzhi
 * @description LeetCode 239 题 滑动窗口最大值
 */


/**
 * @create zhangzhi
 * @date 2022/4/18
 * @time 21:16
 * @description 自定义单调队列
 */
class MyQueue{
    Deque<Integer> deque = new LinkedList<>();

    // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    // 同时判断队列当前是否为空
    void poll(int val){
        if (!deque.isEmpty() && val == deque.peek()){
            deque.poll();
        }
    }

    // 添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    // 保证队列元素单调递减
    // 比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void push(int val){
        while (!deque.isEmpty() && val > deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }

    // 队列队顶元素始终为最大值
    int peek(){
        return deque.peek();
    }
}

public class SlidingWindowMaximum {

    public static int[] solution(int[] nums, int k){
        if (nums.length == 1){
            return new int[]{nums[0]};
        }

        MyQueue myQueue = new MyQueue();

        int[] ans = new int[nums.length - k + 1];
        // 先将前k的元素放入队列
        for (int i = 0; i < k;i++){
            myQueue.push(nums[i]);
        }
        int idx = 0;
        ans[idx++] = myQueue.peek();

        for (int i = k; i < nums.length;i++){
            // 滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            // i-k 是因为最开始就把前 k 个元素放了进去
            myQueue.poll(nums[i - k]);
            // 滑动窗口加入最后面的元素
            myQueue.push(nums[i]);
            // 记录对应的最大值
            ans[idx++] = myQueue.peek();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(solution(nums,1)));
    }
}
