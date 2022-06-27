package SummerPlan_2022.day_6_27;

/**
 * @DATE 2022/6/27
 * @TIME 21:52
 * @Created by zhangzhi
 * @description LeetCode 198 题 打家劫舍
 * dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
 * 决定dp[i]的因素就是第i房间偷还是不偷。
 * 如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房一定是不考虑的，
 * 找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。
 * 如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，
 * （注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）
 * 然后dp[i]取最大值，即dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 2)return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
