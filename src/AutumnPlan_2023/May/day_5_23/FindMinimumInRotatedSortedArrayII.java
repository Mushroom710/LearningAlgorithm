package AutumnPlan_2023.May.day_5_23;

// @date 2023/5/23
// @time 9:54
// @author zhangzhi
// @description LeetCode 154. 寻找旋转排序数组中的最小值 II
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right + 1]){
                right = mid - 1;
            }else if(nums[mid] > nums[right + 1]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
