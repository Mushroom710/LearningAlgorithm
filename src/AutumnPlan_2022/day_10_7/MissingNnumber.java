package AutumnPlan_2022.day_10_7;

// @date 2022/10/7
// @time 14:52
// @author zhangzhi
// @description LeetCode 268 题 丢失的数字
// 每个数字只出现一次，所以可以对数组排序，依次遍历

import java.util.Arrays;

public class MissingNnumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < n;i++){
            if(i != nums[i]){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
}
