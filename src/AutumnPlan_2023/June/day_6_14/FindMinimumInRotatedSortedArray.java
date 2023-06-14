package AutumnPlan_2023.June.day_6_14;

// @date 2023/6/14
// @time 11:41
// @author zhangzhi
// @description LeetCode 153. 寻找旋转排序数组中的最小值
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[n]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
