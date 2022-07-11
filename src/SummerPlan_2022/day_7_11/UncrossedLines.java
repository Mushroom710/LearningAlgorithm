package SummerPlan_2022.day_7_11;

/**
 * @DATE 2022/7/11
 * @TIME 21:21
 * @Created by zhangzhi
 * @description LeetCode 1035 不相交的线
 * 和 1143 题是一道题
 * 都是找最长公共子序列
 */
public class UncrossedLines {

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1;i <= nums1.length;i++){
            for (int j = 1;j <= nums2.length;j++){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,2};
        int[] nums2 = new int[]{1,2,4};
        System.out.println(maxUncrossedLines(nums1,nums2));
    }
}
