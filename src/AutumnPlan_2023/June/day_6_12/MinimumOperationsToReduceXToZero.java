package AutumnPlan_2023.June.day_6_12;

// @date 2023/6/12
// @time 10:09
// @author zhangzhi
// @description LeetCode 1658. 将 x 减到 0 的最小操作数
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int t = -x;
        for(int num : nums){
            t += num;
        }
        if(t < 0){
            return -1;
        }
        int ans = -1;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum > t){
                sum -= nums[l];
                l++;
            }
            if(sum == t){
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }
}
