package SummerPlan_2022.day_6_27;

/**
 * @DATE 2022/6/27
 * @TIME 22:03
 * @Created by zhangzhi
 * @description LeetCode 213 题 打家劫舍 II
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length < 2)return nums[0];
        int re1 = robRange(nums,1,nums.length - 1);
        int re2 = robRange(nums,0,nums.length - 2);
        return Math.max(re1,re2);
    }

    private static int robRange(int[] nums,int start,int end){
        if (start == end)return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2;i <= end;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}
