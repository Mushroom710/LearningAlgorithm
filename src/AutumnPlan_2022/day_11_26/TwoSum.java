package AutumnPlan_2022.day_11_26;

// @date 2022/11/26
// @time 20:38
// @author zhangzhi
// @description LeetCode 1 题 两数之和
// 梦开始的地方，Leetcode：1.两数之和
// 想当初，第一次做这道题，被难倒了。。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    /**
     * 暴力解法。 题目已给出一定存在一个解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 使用 hashmap 来降低复杂度。键为 target - nums[i]，value 为对应的下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
