package LeetCodeRankWeek_2023._351_week;

// @date 2023/6/25
// @time 10:49
// @author zhangzhi
// @description LeetCode 6910. 将数组划分成若干好子数组的方式
public class three {

    public int numberOfGoodSubarraySplits(int[] nums) {
        long ans = 1;
        int pre = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            if(pre != -1){
                ans = (ans * (i - pre)) % 1000000007;
            }
            pre = i;
        }
        return pre == -1 ? 0 : (int)ans;
    }
}
