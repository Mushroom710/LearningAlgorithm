package AutumnPlan_2023.June.day_6_12;

// @date 2023/6/12
// @time 10:07
// @author zhangzhi
// @description LeetCode 1004. 最大连续1的个数 III
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int[] cnt = new int[2];
        int ans = -1;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            cnt[nums[r]]++;
            while(cnt[0] > k){
                cnt[nums[l]]--;
                l++;
            }
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }
}
