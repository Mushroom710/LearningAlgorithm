package SummerPlan_2022.day_7_1;

/**
 * @DATE 2022/7/1
 * @TIME 20:53
 * @Created by zhangzhi
 * @description LeetCode 674 题 最长连续递增序列
 */
public class LongestContinuousIncreasingSubsequence {

    // 双指针解法
    // 对于nums[right]>nums[left]始终成立，导致right>=nums.length，
    // 所以，在最后，还需要进行一次判断
    public static int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 1;
        int length = 1;
        while (right < nums.length){
            if (nums[right] > nums[right - 1]) {
                right++;
            }else {
                length = Math.max(length,right - left);
                left = right;
                right++;
            }
        }
        return Math.max(length,right - left);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
