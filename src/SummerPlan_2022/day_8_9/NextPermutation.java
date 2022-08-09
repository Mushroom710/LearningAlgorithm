package SummerPlan_2022.day_8_9;

// @DATE 2022/8/9
// @TIME 15:31
// @AUTHOR zhangzhi
// @DESCRIPTION LeetCode 31 题 下一个排列
// 字典序：注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。
//   1.我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
//   2.同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
//   这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小
//  具体地，我们这样描述该算法，对于长度为 n 的排列 a：
//  首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。
//  此时 [i+1,n) 必然是下降序列。
//  如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。
//  这样「较大数」即为 a[j]。
//  交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。
//  我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。

import java.util.Arrays;

public class NextPermutation {

    private static void swap(int[] nums,int start,int end){
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    private static void reverse(int[] nums,int start,int end) {
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }else if(nums.length == 2) {
            swap(nums,0,1);
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i < 0){
            reverse(nums,0,nums.length - 1);
            return;
        }
        while (j >= 0 && nums[i] >= nums[j]){
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i + 1,nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,7,5,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
