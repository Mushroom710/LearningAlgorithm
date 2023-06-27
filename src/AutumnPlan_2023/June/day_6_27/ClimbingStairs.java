package AutumnPlan_2023.June.day_6_27;

// @date 2023/6/27
// @time 12:02
// @author zhangzhi
// @description LeetCode 70. 爬楼梯
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
