package SummerPlan_2022.day_6_4;

/**
 * @DATE 2022/6/4
 * @TIME 19:30
 * @Created by zhangzhi
 * @description LeetCode 53 题 最大子数组和
 */
public class MaximumSubarray {

    /**
     * @create zhangzhi
     * @date 2022/6/4
     * @time 19:34
     * @description
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，
     * 因为负数加上下一个元素 “连续和”只会越来越小。
     * 区间的终止位置，其实就是如果count取到最大值了，及时记录下来了。
     */
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0;i < nums.length;i++){
            count += nums[i];
            if (result < count)result = count;
            if (count <= 0)count = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
