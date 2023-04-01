package AutumnPlan_2023.March.day_3_6;

// @date 2023/3/6
// @time 21:11
// @author zhangzhi
// @description LeetCode 665. 非递减数列
// 想到了一半，但是没有想到在找到不满足 nums[i] <= nums[i+1] 的时候，修改nums[i] = nums[i+1]，再检查一次数组，看是否是非递减序列
// 同样，不满足时，复原，把 nums[i+1] = nums[i]，重复上次的操作。这样才能知道修改后数组是否为非递减序列。
// 题解：https://leetcode.cn/problems/non-decreasing-array/solution/fei-di-jian-shu-lie-by-leetcode-solution-zdsm/

import java.util.Deque;
import java.util.LinkedList;

public class NonDecreasingArray {

    private static boolean isSorted(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPossibility(int[] nums) {
        for(int i = 0;i <= nums.length - 2; i++){
            int x = nums[i];
            int y = nums[i + 1];
            if(x > y){
                nums[i] = y;
                if(isSorted(nums)){
                    return true;
                }
                nums[i] = x;
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    public static boolean checkPossibility2(int[] nums){
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(nums[0]);
        for(int i = 1; i <= nums.length - 1; i++){
            while(!deque.isEmpty() && deque.peekLast() > nums[i]){
                count++;
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        return count <= 1 ? true : false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,1,8};
        //System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility2(nums));
    }
}
