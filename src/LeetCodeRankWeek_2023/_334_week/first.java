package LeetCodeRankWeek_2023._334_week;

// @date 2023/2/26
// @time 10:10
// @author zhangzhi
// @description

public class first {

    public static int[] leftRigthDifference(int[] nums) {
        int left = 0;
        int sum = 0;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            rightSum[i] = sum - left - nums[i];
            leftSum[i] = left;
            left += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
