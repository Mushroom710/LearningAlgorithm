package AutumnPlan_2023.day_3_7;

// @date 2023/3/7
// @time 21:15
// @author zhangzhi
// @description LeetCode 189. 旋转数组

import java.util.Arrays;

public class RotateArray {

    /**
     * 没有考虑到可以轮转任意个来回 ， k 是可以大于数组长度的
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length - k; i++){
            ans[i + k] = nums[i];
        }
        for(int i = nums.length - k,j = 0; i < nums.length; i++,j++){
            ans[j] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }
    }

    /**
     * k是可以大于数组长度的，所以可以轮转任意个来回。那么就需要找到对应的规律。
     * 即：轮转任意次后，其下标为：index = （i + k）% len；找到这个规律，就可以了。
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k){
        int len = nums.length;
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[(i + k) % len] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }
    }

    /**
     * 原地反转的推导有点难理解
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k){
        int len = nums.length;
        int ik = nums[k % len];
        for(int i = 0; i < len; i++){
            int tmp = nums[(i + k) % len];
            nums[(i + k) % len] = nums[i];
            nums[i - 1] = tmp;
        }
        nums[len - 1] = ik;
    }

    /**
     * 反转数组法 -- 要考虑好边界！
     * 先把整个数组反转
     * 然后再反转 [0, (k mod n) - 1] 的元素
     * 和 [k mod n, len - 1] 的元素
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k){
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        rotate4(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
