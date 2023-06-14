package AutumnPlan_2023.June.day_6_14;

// @date 2023/6/14
// @time 11:39
// @author zhangzhi
// @description LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    private int bs(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = bs(nums, target);
        if(nums.length == start || nums[start] != target){
            return new int[]{-1, -1};
        }
        int end = bs(nums, target + 1) - 1;
        return new int[]{start, end};
    }
}
