package AutumnPlan_2022.day_11_1;

// @date 2022/11/1
// @time 20:56
// @author zhangzhi
// @description leetcode 704. 二分查找 二分查找，注意左闭右闭区间和左闭右开区间的区别

public class BinarySearch {

    public static int binarySearch(int nums[],int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
