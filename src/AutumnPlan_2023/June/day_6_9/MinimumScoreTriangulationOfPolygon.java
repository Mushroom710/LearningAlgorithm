package AutumnPlan_2023.June.day_6_9;

// @date 2023/6/9
// @time 17:17
// @author zhangzhi
// @description LeetCode 1039. 多边形三角剖分的最低得分
public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i = n - 3; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                int result = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    result = Math.min(result, dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
                dp[i][j] = result;
            }
        }
        return dp[0][n - 1];
    }
}
