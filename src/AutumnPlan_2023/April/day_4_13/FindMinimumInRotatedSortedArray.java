package AutumnPlan_2023.April.day_4_13;

// @date 2023/4/13
// @time 21:56
// @author zhangzhi
// @description LeetCode 153. 寻找旋转排序数组中的最小值

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left);
            if(nums[mid] > nums[n - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
