package AutumnPlan_2023.April.day_4_13;

// @date 2023/4/13
// @time 21:57
// @author zhangzhi
// @description LeetCode 33. 搜索旋转排序数组

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // [0, mid] 这个区间是有序的
            if(nums[mid] >= nums[0]){
                // target 在 [0, mid] 这个区间
                if(target >= nums[0] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // [mid, n - 1] 这个区间是有序的
                // target 在 [mid, n-1]这个区间
                if(target <= nums[n - 1] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
