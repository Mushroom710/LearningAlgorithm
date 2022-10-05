package AutumnPlan_2022.day_10_5;

// @date 2022/10/5
// @time 21:55
// @author zhangzhi
// @description LeetCode 287 题 寻找重复数
// 题解：https://leetcode.cn/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/


public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
