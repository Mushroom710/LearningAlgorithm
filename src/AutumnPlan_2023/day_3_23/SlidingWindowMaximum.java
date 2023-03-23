package AutumnPlan_2023.day_3_23;

// @date 2023/3/23
// @time 22:20
// @author zhangzhi
// @description LeetCode 239. 滑动窗口最大值

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int idx = 0;
        int[] ans = new int[len - k + 1];
        for(int i = 0; i < len; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1){
                ans[idx++] = nums[deque.peek()];
            }
        }
        return ans;
    }
}
