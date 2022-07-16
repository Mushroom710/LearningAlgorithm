package SummerPlan_2022.day_7_16;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @DATE 2022/7/16
 * @TIME 20:39
 * @Created by zhangzhi
 * @description LeetCode 503 题 下一个更大元素 II
 */
public class NextGreaterElementII {

    // 直接遍历两次数组 + 单调栈
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        boolean[] b = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        simple_stack(nums, ans, b, deque);
        simple_stack(nums, ans, b, deque);
        for (int i = 0;i < nums.length;i++){
            if (!b[i])ans[i] = -1;
        }
        return ans;
    }

    private static void simple_stack(int[] nums, int[] ans, boolean[] b, Deque<Integer> deque) {
        for (int i = 0;i < nums.length;i++){
            if (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    if (!b[deque.peekLast()]) {
                        b[deque.peekLast()] = true;
                        ans[deque.pollLast()] = nums[i];
                    }else {
                        deque.pollLast();
                    }
                }
            }
            deque.addLast(i);
        }
    }

    // 和我最开始的想法一样，但是后来对求余计算估计错了
    public static int[] other_solution(int[] nums){
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0;i < nums.length * 2;i++ ){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i % nums.length]){
                ans[deque.pollLast()] = nums[i % nums.length];
            }
            deque.addLast(i % nums.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
        System.out.println(Arrays.toString(other_solution(nums)));
    }
}
