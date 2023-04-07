package AutumnPlan_2023.April.day_4_7;

// @date 2023/4/7
// @time 21:38
// @author zhangzhi
// @description

public class OnesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '1'){
                    count[i][1]++;
                }else{
                    count[i][0]++;
                }
            }
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if((j < count[i][0]) || (k < count[i][1])){
                        dp[i + 1][j][k] = dp[i][j][k];
                    }else{
                        dp[i + 1][j][k] = Math.max(dp[i][j][k], dp[i][j - count[i][0]][k - count[i][1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}
