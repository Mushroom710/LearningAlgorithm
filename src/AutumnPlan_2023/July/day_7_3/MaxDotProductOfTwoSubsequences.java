package AutumnPlan_2023.July.day_7_3;

import java.util.Arrays;

// @date 2023/7/3
// @time 11:40
// @author zhangzhi
// @description LeetCode 1458. 两个子序列的最大点积
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MIN_VALUE / 2);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int x = nums1[i] * nums2[j];
                dp[i + 1][j + 1] = x;
                dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j] + x, dp[i + 1][j + 1]), Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        return dp[n][m];
    }
}
