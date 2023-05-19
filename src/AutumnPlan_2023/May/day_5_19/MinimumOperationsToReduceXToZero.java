package AutumnPlan_2023.May.day_5_19;

// @date 2023/5/19
// @time 10:20
// @author zhangzhi
// @description LeetCode 1658. 将 x 减到 0 的最小操作数
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for(int num : nums){
            target += num;
        }
        if(target < 0){
            return -1;
        }
        int left = 0;
        int ans = -1;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum > target){
                sum -= nums[left];
                left++;
            }
            if(sum == target){
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }
}
