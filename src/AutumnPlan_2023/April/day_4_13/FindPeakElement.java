package AutumnPlan_2023.April.day_4_13;

// @date 2023/4/13
// @time 21:56
// @author zhangzhi
// @description LeetCode 162. 寻找峰值

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[n - 1] > nums[n - 2]){
            return n - 1;
        }
        int left = 1;
        int right = n - 2;
        int idx = 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                idx = mid;
                break;
            }else if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return idx;
    }
}
