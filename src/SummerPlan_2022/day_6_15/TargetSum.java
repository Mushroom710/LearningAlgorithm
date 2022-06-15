package SummerPlan_2022.day_6_15;

import java.util.Arrays;

/**
 * @DATE 2022/6/15
 * @TIME 19:37
 * @Created by zhangzhi
 * @description LeetCode 494 题 目标和
 * 1.确定 dp数组以及下标的含义
 *  dp[j] 表示：填满 j（包括 j）这么大容积的包，有 dp[j]种方法
 *  确定递推公式
 * 2.有哪些来源可以推出dp[j]呢
 *  不考虑nums[i]的情况下，填满容量为j - nums[i]的背包，有dp[j - nums[i]]种方法。
 *  那么只要搞到nums[i]的话，凑成dp[j]就有dp[j - nums[i]] 种方法。
 *  例如：dp[j]，j 为5，
 *   已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 dp[5]。
 *   已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 dp[5]。
 *   已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 dp[5]
 *   已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 dp[5]
 *   已经有一个5 （nums[i]）的话，有 dp[0]中方法 凑成 dp[5]
 *   那么凑整dp[5]有多少方法呢，也就是把 所有的 dp[j - nums[i]] 累加起来
 *   所以求组合类问题的公式，都是类似这种：
 *    dp[j] += dp[j - nums[i]];~
 */
public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (Math.abs(target) > sum)return 0;
        if ((target + sum) % 2 == 1)return 0;
        int size = (target + sum) / 2;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0;i < nums.length;i++){
            for (int j = size;j >= nums[i];j--){
                // 求组合类问题的公式，都是类似这种：
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[size];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
