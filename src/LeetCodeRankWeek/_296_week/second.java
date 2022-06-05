package LeetCodeRankWeek._296_week;

import java.util.Arrays;

/**
 * @DATE 2022/6/5
 * @TIME 9:59
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int partitionArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        Arrays.sort(nums);
        while (end < nums.length){
            if (nums[end] - nums[start] <= k){
                end++;
            }else {
                count++;
                start = end;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,4,5};
        System.out.println(partitionArray(nums,0));
    }
}
