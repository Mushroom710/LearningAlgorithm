package AutumnPlan_2023.day_3_14;

// @date 2023/3/14
// @time 21:25
// @author zhangzhi
// @description LeetCode 209. 长度最小的子数组

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for(int quick = 0; quick < nums.length; quick++){
            sum += nums[quick];
            if(sum >= target) {
                while (slow <= quick && sum >= target) {
                    len = Math.min(len, quick - slow + 1);
                    sum -= nums[slow];
                    slow++;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3,5,10,7,4,9,2,8};
        System.out.println(minSubArrayLen(15, nums));
    }
}
