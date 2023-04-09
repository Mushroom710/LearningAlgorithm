package AutumnPlan_2023.April.day_4_9;

// @date 2023/4/9
// @time 21:27
// @author zhangzhi
// @description LeetCode 279. 完全平方数

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            // 绝妙的方法，j * j 就可以找出比 i 小的对应的完全平方数了
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
