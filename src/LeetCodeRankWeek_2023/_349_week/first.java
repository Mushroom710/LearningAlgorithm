package LeetCodeRankWeek_2023._349_week;

import java.util.Arrays;

// @date 2023/6/11
// @time 10:07
// @author zhangzhi
// @description
public class first {

    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        return nums.length <= 2 ? -1 : nums[1];
    }
}
