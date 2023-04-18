package AutumnPlan_2023.April.day_4_18;

// @date 2023/4/18
// @time 22:07
// @author zhangzhi
// @description LeetCode 1035. 不相交的线
// 这题仔细分析后发现就是求最长公共子序列 -- 和 1143. 最长公共子序列 简直一样
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];
    }
}
