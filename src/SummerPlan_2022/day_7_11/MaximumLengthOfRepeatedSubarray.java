package SummerPlan_2022.day_7_11;

/**
 * @DATE 2022/7/11
 * @TIME 20:47
 * @Created by zhangzhi
 * @description LeetCode 718 题 最长重复子数组
 */
public class MaximumLengthOfRepeatedSubarray {

    // 1.确定dp数组（dp table）以及下标的含义
    //  dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
    // 2.确定递推公式
    //  根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
    //  即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
    //  根据递推公式可以看出，遍历i 和 j 要从1开始！
    // 3.dp数组如何初始化
    //  根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的！
    //  但dp[i][0] 和dp[0][j]要初始值，因为 为了方便递归公式dp[i][j] = dp[i - 1][j - 1] + 1;
    //  所以dp[i][0] 和dp[0][j]初始化为0。
    // 4.确定遍历顺序
    //  外层for循环遍历A，内层for循环遍历B。
    //  那又有同学问了，外层for循环遍历B，内层for循环遍历A。不行么？
    //  也行，一样的，我这里就用外层for循环遍历A，内层for循环遍历B了。
    //  同时题目要求长度最长的子数组的长度。所以在遍历的时候顺便把dp[i][j]的最大值记录下来。
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1;i <= nums1.length;i++){
            for (int j = 1;j <= nums2.length;j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        System.out.println(findLength(nums1,nums2));
    }
}
