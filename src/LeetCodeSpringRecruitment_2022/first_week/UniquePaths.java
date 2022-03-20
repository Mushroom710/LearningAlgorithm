package LeetCodeSpringRecruitment_2022.first_week;

import java.util.Arrays;

/**
 * @DATE 2022/3/20
 * @TIME 20:27
 * @Created by zhangzhi
 * @description LeetCode 62 题 不同路径
 */
public class UniquePaths {

    /**
     * @create zhangzhi
     * @date 2022/3/20
     * @time 20:37
     * @description 状态定义：dp[m][n] 表示到这个位置的方法数
     * 递推方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public static int solution(int m,int n){
        int[][] dp = new int[m][n];
        // 初始化：横着和竖着只有一种走法
        Arrays.fill(dp[0],1);
        for(int i = 1; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(1,1));
    }
}
