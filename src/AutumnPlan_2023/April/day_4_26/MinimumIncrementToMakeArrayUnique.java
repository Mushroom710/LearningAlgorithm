package AutumnPlan_2023.April.day_4_26;

import java.util.Arrays;

// @date 2023/4/26
// @time 21:55
// @author zhangzhi
// @description LeetCode 945. 使数组唯一的最小增量
public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                continue;
            }
            int addOne = nums[i - 1] - nums[i] + 1;
            total += addOne;
            nums[i] += addOne;
        }
        return total;
    }
}
