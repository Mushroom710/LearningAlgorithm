package AutumnPlan_2023.May.day_5_22;

// @date 2023/5/22
// @time 11:28
// @author zhangzhi
// @description LeetCode 162. 寻找峰值
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
