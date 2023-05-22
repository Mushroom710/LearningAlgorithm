package AutumnPlan_2023.May.day_5_22;

// @date 2023/5/22
// @time 11:29
// @author zhangzhi
// @description LeetCode 153. 寻找旋转排序数组中的最小值
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[nums.length - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
