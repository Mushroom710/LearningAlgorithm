package AutumnPlan_2023.June.day_6_13;

import java.util.Arrays;

// @date 2023/6/13
// @time 10:40
// @author zhangzhi
// @description LeetCode 16. 最接近的三数之和
public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE / 2;
        for(int i = 0; i < nums.length - 2; i++){
            int x = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = x + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if(sum > target){
                    right -= 1;
                    while(left < right && nums[right] == nums[right + 1]){
                        right -= 1;
                    }
                }else if(sum < target){
                    left += 1;
                    while(left < right && nums[left] == nums[left - 1]){
                        left += 1;
                    }
                }else{
                    return sum;
                }
            }
        }
        return ans;
    }
}
