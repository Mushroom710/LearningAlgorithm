package LeetCodeSpringRecruitment_2022.second_week.day_one;

/**
 * @DATE 2022/3/21
 * @TIME 10:09
 * @Created by zhangzhi
 * @description LeetCode 63 题 不同路径 2
 */
public class UniquePathsII {

    /**
     * @create zhangzhi
     * @date 2022/3/21
     * @time 19:36
     * @description 想歪了。。。。
     */
    public static int solution(int[][] obstacleGrid){
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length] == 1){
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }else if(i == 0) {
                    dp[i][j] = 1;
                }else if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 1; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j-1] == -1 && obstacleGrid[i-1][j] == -1){
                    dp[i][j] = 0;
                }else if(obstacleGrid[i][j-1] == -1){
                    dp[i][j] = dp[i-1][j];
                }else if(obstacleGrid[i-1][j] == -1){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * @create zhangzhi
     * @date 2022/3/21
     * @time 19:50
     * @description 上一个解法没有考虑到只能向下或向右走
     * 在初始化的时候没有考虑到碰到障碍物后直接break，因为障碍物后的坐标是无法到达的。
     */
    public static int solution_two(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }else {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }else {
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{1,0}};
        System.out.println(solution_two(obstacleGrid));
    }

}
