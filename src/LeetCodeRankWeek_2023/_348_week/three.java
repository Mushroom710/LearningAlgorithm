package LeetCodeRankWeek_2023._348_week;

import java.util.Arrays;

// @date 2023/6/4
// @time 10:55
// @author zhangzhi
// @description
public class three {

    public long matrixSumQueries(int n, int[][] queries) {
        int col = n;
        int row = n;
        boolean[] brow = new boolean[n];
        boolean[] bcol = new boolean[n];
        long ans = 0;
        for(int i = queries.length - 1; i >= 0; i--){
            int[] q = queries[i];
            if(q[0] == 0){
                if(!brow[q[1]]){
                    ans += (long) q[2] * col;
                    row--;
                    brow[q[1]] = true;
                }
            }else{
                if(!bcol[q[1]]){
                    ans += (long) q[2] * row;
                    col--;
                    bcol[q[1]] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] q = new int[][]{{0,0,1},{1,2,2},{0,2,3},{1,0,4}};
        System.out.println(new three().matrixSumQueries(3, q));
    }
}
