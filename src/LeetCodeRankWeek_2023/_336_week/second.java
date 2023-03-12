package LeetCodeRankWeek_2023._336_week;

// @date 2023/3/12
// @time 10:22
// @author zhangzhi
// @description

import java.util.Arrays;

public class second {

    private static void reverse(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        int total = 0;
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum <= 0){
                break;
            }
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-3,0};
        System.out.println(maxScore(nums));
    }
}
