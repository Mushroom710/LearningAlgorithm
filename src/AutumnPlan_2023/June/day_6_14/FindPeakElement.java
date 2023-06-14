package AutumnPlan_2023.June.day_6_14;

// @date 2023/6/14
// @time 11:40
// @author zhangzhi
// @description LeetCode 162. 寻找峰值
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid - 1]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
