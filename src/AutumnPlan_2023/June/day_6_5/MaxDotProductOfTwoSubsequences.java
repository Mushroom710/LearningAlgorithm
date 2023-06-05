package AutumnPlan_2023.June.day_6_5;

// @date 2023/6/5
// @time 11:22
// @author zhangzhi
// @description LeetCode 1458. 两个子序列的最大点积
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int k = nums1[i] * nums2[j];
                max = Math.max(max, k);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + k, Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        return dp[nums1.length][nums2.length] > 0 ? dp[nums1.length][nums2.length] : max;
    }
}
