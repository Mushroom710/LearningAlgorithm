package AutumnPlan_2023.June.day_6_27;

// @date 2023/6/27
// @time 12:03
// @author zhangzhi
// @description LeetCode 2466. 统计构造好字符串的方案数
public class CountWaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int)Math.pow(10, 9) + 7;
        int[] dp = new int[high + 1];
        int ans = 0;
        dp[0] = 1;
        for(int i = 1; i <= high; i++){
            if(i >= one){
                dp[i] = (dp[i - one] + dp[i]) % mod;
            }
            if(i >= zero){
                dp[i] = (dp[i - zero] + dp[i]) % mod;
            }
            if(i >= low){
                ans = (ans + dp[i]) % mod;
            }
        }
        return ans;
    }
}
