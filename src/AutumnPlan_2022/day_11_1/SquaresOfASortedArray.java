package AutumnPlan_2022.day_11_1;

// @date 2022/11/1
// @time 21:26
// @author zhangzhi
// @description leetcode 977. 有序数组的平方

import java.util.Arrays;

public class SquaresOfASortedArray {

    /**
     * 暴力解法。先平方，然后排序！
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * O(n)解法，数组有序，那么平方后的最大值只会出现在两边，不会在中间！
     * @param nums
     * @return
     */
    public static int[] sortedSquares_ON(int[] nums){
        // O(n) 解法，没能解出来
//        for(int i = nums.length - 1;i >= 0;i--){
//            if(nums[0] * nums[0] <= nums[i] * nums[i]){
//                nums[i] *= nums[i];
//            }else {
//                int tmp = nums[i];
//                nums[i] = nums[0] * nums[0];
//                nums[0] = tmp;
//            }
//        }
//        return nums;
        // 正解
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for(int i = 0,j = nums.length - 1;i <= j;){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                result[k--] = nums[i] * nums[i];
                i++;
            }else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-5,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquares_ON(nums)));
    }
}
