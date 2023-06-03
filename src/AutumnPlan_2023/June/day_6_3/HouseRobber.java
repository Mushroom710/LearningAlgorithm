package AutumnPlan_2023.June.day_6_3;

import java.util.Arrays;

// @date 2023/6/3
// @time 11:18
// @author zhangzhi
// @description LeetCode 198. 打家劫舍
public class HouseRobber {
    int[] nums;
    int[] cache;

    private int dfs(int i){
        if(i < 0){
            return 0;
        }
        if(cache[i] != -1){
            return cache[i];
        }
        return cache[i] = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
    }

    public int rob(int[] nums) {
        this.nums = nums;
        this.cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums.length - 1);
    }
}
