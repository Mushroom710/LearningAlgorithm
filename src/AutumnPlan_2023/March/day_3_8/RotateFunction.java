package AutumnPlan_2023.March.day_3_8;

// @date 2023/3/8
// @time 21:36
// @author zhangzhi
// @description LeetCode 396. 旋转函数

public class RotateFunction {

    /**
     * 找规律：
     *  nums: [A0,A1,A2,A3]
     *
     *  F0 = 0*A0 + 1*A1 + 2*A2 + 3*A3
     *
     *  F1 = 0*A3 + 1*A0 + 2*A1 + 3*A2
     *     = F0 + A0 + A1 + A2 - 3*A3
     *     = F0 + sum-A3 - 3*A3
     *     = F0 + sum - 4*A3
     *
     *  F2 = 0*A2 + 1*A3 + 2*A0 + 3*A1
     *     = F1 + A0 + A1 + A3 - 3*A2
     *     = F1 + sum - 4*A2
     *
     *  F3 = 0*A1 + 1*A2 + 2*A3 + 3*A0
     *     = F2 + A2 + A3 + A0 - 3*A1
     *     = F2 + sum - 4*A1
     *  抽象为一个等式：
     *      F(i) = F(i-1) + sum - n * A(n-i)
     * @param nums
     * @return
     */
    public static int maxRotateFunction(int[] nums) {
        int sum = 0;
        int ans = 0;
        int pre = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            pre += i * nums[i];
        }
        ans = pre;
        for(int i = 1; i < n; i++){
            pre = pre + sum - n * nums[nums.length - i];
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}
