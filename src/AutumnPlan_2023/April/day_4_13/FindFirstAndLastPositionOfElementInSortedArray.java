package AutumnPlan_2023.April.day_4_13;

// @date 2023/4/13
// @time 21:55
// @author zhangzhi
// @description LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置

public class FindFirstAndLastPositionOfElementInSortedArray {

    private static int binarySearch(int[] nums, int target){
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
        int start = binarySearch(nums, target);
        // nums[start] != target 表示数组中没有找到 target
        if(start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        // 转换为第一个大于等于x+1的那个数的下标的左边位置
        int end = binarySearch(nums, target + 1) - 1;
        return new int[]{start, end};

    }
}
