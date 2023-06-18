package LeetCodeRankWeek_2023._350_week;

import java.util.Arrays;

// @date 2023/6/18
// @time 10:27
// @author zhangzhi
// @description
public class second {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            ans = Math.min(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        return ans;
    }
}
