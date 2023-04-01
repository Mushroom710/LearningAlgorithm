package AutumnPlan_2023.March.day_3_20;

// @date 2023/3/20
// @time 21:05
// @author zhangzhi
// @description LeetCode 1. 两数之和 梦开始的地方

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
