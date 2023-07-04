package AutumnPlan_2023.July.day_7_4;

// @date 2023/7/4
// @time 11:55
// @author zhangzhi
// @description LeetCode 300. 最长递增子序列
public class LongestIncreasingSubsequence {
    private int bsLeft(int[] nums, int target, int ng){
        int l = 0;
        int r = ng - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l += 1;
            }else{
                r -= 1;
            }
        }
        return l;
    }

    public int lengthOfLIS(int[] nums) {
        int ng = 0;
        for(int i = 0; i < nums.length; i++){
            int idx = bsLeft(nums, nums[i], ng);
            if(idx == ng){
                nums[ng] = nums[i];
                ng += 1;
            }else{
                nums[idx] = nums[i];
            }
        }
        return ng;
    }
}
