package AutumnPlan_2023.May.day_5_22;

// @date 2023/5/22
// @time 11:28
// @author zhangzhi
// @description LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    // 大于等于 target
    private int bs(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        int l = bs(nums, target);
        if(l == nums.length || nums[l] != target){
            return new int[]{-1, -1};
        }
        int r = bs(nums, target + 1) - 1;
        return new int[]{l, r};
    }
}
