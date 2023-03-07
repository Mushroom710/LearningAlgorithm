package AutumnPlan_2023.day_3_7;

// @date 2023/3/7
// @time 20:59
// @author zhangzhi
// @description LeetCode 283. 移动零

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){
                continue;
            }
            int j = i + 1;
            while(j < len && nums[j] == 0){
                j++;
            }
            if(j >= len){
                break;
            }
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
