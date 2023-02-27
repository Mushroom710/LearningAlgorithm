package AutumnPlan_2023.day_2_27;

// @date 2023/2/27
// @time 20:28
// @author zhangzhi
// @description LeetCode 1144. 递减元素使数组呈锯齿状
// 题解：
// https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/solution/mei-you-si-lu-yi-bu-bu-ti-shi-ni-si-kao-cm0h2/

/**
 * @author zhangzhi
 */
public class DecreaseElements2MakeArrayZigzag{

    public static int movesToMakeZigzag(int[] nums) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            ans[i % 2] += Math.max(nums[i] - Math.min(left,right) + 1, 0);
        }
        return Math.min(ans[0],ans[1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(movesToMakeZigzag(nums));
    }
}
