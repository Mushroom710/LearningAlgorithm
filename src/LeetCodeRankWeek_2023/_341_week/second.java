package LeetCodeRankWeek_2023._341_week;

// @date 2023/4/16
// @time 10:21
// @author zhangzhi
// @description
public class second {

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = Integer.MAX_VALUE;
        int score = 0;
        for(int divisor : divisors){
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % divisor == 0){
                    sum++;
                }
            }
            if(sum > score){
                ans = divisor;
                score = sum;
            }
            if(sum == score){
                ans = Math.min(ans, divisor);
            }
        }
        return ans;
    }
}
