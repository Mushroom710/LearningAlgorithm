package SummerPlan_2022.day_6_25;

/**
 * @DATE 2022/6/25
 * @TIME 17:33
 * @Created by zhangzhi
 * @description LeetCode 377 题 组合总和 Ⅳ
 * 如果求组合数就是外层 for循环遍历物品，内层 for遍历背包。
 * 如果求排列数就是外层 for遍历背包，内层 for循环遍历物品。
 */
public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0;i <= target;i++){
            for (int j = 0;j < nums.length;j++){
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
}
