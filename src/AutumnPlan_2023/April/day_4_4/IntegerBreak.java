package AutumnPlan_2023.April.day_4_4;

// @date 2023/4/4
// @time 22:09
// @author zhangzhi
// @description LeetCode 343. 整数拆分
// 难点是根据题目的提示推出子问题
// j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘。

public class IntegerBreak {

    /**
     * 回溯法
     */
    int[] cache;
    private int dfs(int i){
        if(i == 2){
            return 1;
        }
        if(cache[i] != 0){
            return cache[i];
        }
        int ans = 0;
        for(int j = 1; j < i - 1; j++){
            ans = Math.max(ans, Math.max(j * (i - j), j * dfs(i - j)));
            cache[i] = ans;
        }
        return ans;
    }

    public int integerBreak2(int n) {
        cache = new int[60];
        return dfs(n);
    }

    /**
     * 动态规划
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i - 1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
