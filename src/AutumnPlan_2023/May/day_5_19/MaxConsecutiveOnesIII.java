package AutumnPlan_2023.May.day_5_19;

// @date 2023/5/19
// @time 9:36
// @author zhangzhi
// @description LeetCode 1004. 最大连续1的个数 III
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int[] cnt = new int[2];
        int left = 0;
        int ans = 0;
        for(int right = 0; right < nums.length; right++){
            cnt[nums[right]] += 1;
            if(cnt[0] <= k){
                ans = Math.max(ans, right - left + 1);
            }
            while(cnt[0] > k){
                cnt[nums[left]] -= 1;
                left += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums, 2));
    }
}
