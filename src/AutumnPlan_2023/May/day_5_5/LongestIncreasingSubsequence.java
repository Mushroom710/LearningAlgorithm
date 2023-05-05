package AutumnPlan_2023.May.day_5_5;

import java.util.Arrays;

// @date 2023/5/5
// @time 21:39
// @author zhangzhi
// @description LeetCode 300. 最长递增子序列
public class LongestIncreasingSubsequence {
    private int[] nums;
    private int[][] cache;

    /**
     * i：枚举的范围
     * j：上一个选的数字的下标
     */
    private int dfs(int i, int j){
        // 为什么采用了 + 1？这是因为 i 在递归的过程中可以减到 -1，所以为了避免负数下标，就用了 +1
        // 同样，初始化 cache 数组也要初始化长度为 nums.length+1
        // 不过题目已经给出了明确的范围，所以可以直接初始化为给定的范围
        if(cache[i + 1][j + 1] != -1){
            return cache[i + 1][j + 1];
        }
        int result = 0;
        // k <= i 为什么可以等于，这是因为 k 可以枚举到 i 这个位置
        for(int k = 0; k <= i; k++){
            if(nums[k] < nums[j]){
                result = Math.max(result, dfs(k - 1, k));
            }
        }
        cache[i + 1][j + 1] = result + 1;
        return result + 1;
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.cache = new int[2501][2501];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        int ans = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            ans = Math.max(ans, dfs(i - 1, i));
        }
        return ans;
    }
}
