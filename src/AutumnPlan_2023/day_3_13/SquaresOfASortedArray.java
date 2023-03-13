package AutumnPlan_2023.day_3_13;

// @date 2023/3/13
// @time 21:43
// @author zhangzhi
// @description LeetCode 977. 有序数组的平方

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int k = right;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                ans[k--] = nums[left] * nums[left];
                left++;
            }else{
                ans[k--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
