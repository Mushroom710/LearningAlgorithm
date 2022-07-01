package SummerPlan_2022.day_7_1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @DATE 2022/7/1
 * @TIME 20:27
 * @Created by zhangzhi
 * @description LeetCode 300 题 最长递增子序列
 */
public class LongestIncreasingSubsequence {

    private static void out(Deque<Integer> deque,int num){
        while (!deque.isEmpty() && deque.peekLast() >= num){
            deque.removeLast();
        }
    }

    // 单调栈。但是思路错了。
    public static int lengthOfLIS(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0;i < nums.length;i++){
            if (!deque.isEmpty() && deque.peekLast() >= nums[i]){
                out(deque,nums[i]);
            }
            deque.addLast(nums[i]);
        }
        return deque.size();
    }

    // 1.dp[i]的定义
    //  dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
    // 2.状态转移方程
    //  位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
    //  所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
    //  注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
    // 3.dp[i]的初始化
    //  每一个i，对应的dp[i]（即最长上升子序列）起始大小至少都是1.
    public static int lengthOfLIS_dp(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        dp[0] = 1;
        int result = 0;
        for (int i = 1;i < nums.length;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result)result = dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS_dp(nums));

    }
}
