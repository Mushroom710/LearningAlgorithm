package AutumnPlan_2023.May.day_5_22;

// @date 2023/5/22
// @time 11:46
// @author zhangzhi
// @description LeetCode 33. 搜索旋转排序数组
public class SearchInRotatedSortedArray {
    private boolean isBule(int[] nums, int mid, int target){
        int end = nums[nums.length - 1];
        if(nums[mid] > end){
            return target > end && target <= nums[mid];
        }else{
            return end < target || target <= nums[mid];
        }
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBule(nums, mid, target)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //System.out.println(left + "-" + right);
        return left == nums.length ? -1 : nums[left] == target ? left : -1;
    }
}
