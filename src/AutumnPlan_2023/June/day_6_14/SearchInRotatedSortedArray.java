package AutumnPlan_2023.June.day_6_14;

// @date 2023/6/14
// @time 11:41
// @author zhangzhi
// @description LeetCode 33. 搜索旋转排序数组
public class SearchInRotatedSortedArray {
    private boolean isBlue(int[] nums, int target, int mid){
        int end = nums[nums.length - 1];
        if(nums[mid] > end){
            return target > end && target <= nums[mid];
        }else{
            return target > end || target <= nums[mid];
        }
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBlue(nums, target, mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left == nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }
}
