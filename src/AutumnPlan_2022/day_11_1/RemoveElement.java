package AutumnPlan_2022.day_11_1;

// @date 2022/11/1
// @time 21:04
// @author zhangzhi
// @description leetcode 27. 移除元素 双指针法。前后指针，前指针找等于val的值，后指针找不等于val的值，找到后交换。注意临界值！！！

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if(nums.length <= 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            while (left <= right && nums[left] != val){
                left++;
            }
            while (left <= right && nums[right] == val){
                right--;
            }
            if(left > right){
                return left;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        if(nums[right] == val){
            return right - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
