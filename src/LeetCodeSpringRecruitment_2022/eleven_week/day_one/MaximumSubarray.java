package LeetCodeSpringRecruitment_2022.eleven_week.day_one;

/**
 * @DATE 2022/5/23
 * @TIME 21:50
 * @Created by zhangzhi
 * @description LeetCode 53 题 最大子数组和
 */
public class MaximumSubarray {

    /**
     * @create zhangzhi
     * @date 2022/5/23
     * @time 21:57
     * @description 暴力经典超时
     */
    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i++){
            int temp = 0;
            for (int j = i; j < nums.length;j++){
                temp += nums[j];
                sum = Math.max(temp, sum);
            }
        }
        return sum;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/23
     * @time 22:01
     * @description
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，
     * 因为负数加上下一个元素 “连续和”只会越来越小。
     */
    public static int maxSubArray_greedy(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length;i++){
            count += nums[i];
            if (count > sum){// 取区间累计的最大值（相当于不断确定最大子序终止位置）
                sum = count;
            }
            if (count < 0){ // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
                count = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray_greedy(nums));
    }
}
