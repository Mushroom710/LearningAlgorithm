package AutumnPlan_2023.April.day_4_6;

// @date 2023/4/6
// @time 22:22
// @author zhangzhi
// @description LeetCode 1049. 最后一块石头的重量 II

import java.util.Arrays;

public class LastStoneWeightII {

    private int[] stones;
    private int sum;
    private int[][] cache;

    /**
     * 回溯法 -- 虽然有 0-1背包的思想，但是这个回溯代码并不能转换为递推
     */
    private int dfs(int i, int c){
        if(i < 0){
            int diff = sum - c;
            return Math.abs(diff - c);
        }
        if(cache[i][c] != -1){
            return cache[i][c];
        }
        int left = dfs(i - 1, c);
        int right = dfs(i - 1, c + stones[i]);

        cache[i][c] = Math.min(left, right);
        return cache[i][c];
    }

    public int lastStoneWeightII_dfs(int[] stones) {
        this.stones = stones;
        for(int stone : stones){
            sum += stone;
        }
        this.cache = new int[stones.length + 1][sum + 1];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        return dfs(stones.length - 1, 0);
    }

    /**
     * 0-1背包  常规写法
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        for(int j = stones[0]; j <= target; j++){
            dp[0][j] = stones[0];
        }
        for(int i = 1; i < stones.length; i++){
            for(int j = 1; j <= target; j++){
                if(j < stones[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
    }
}
