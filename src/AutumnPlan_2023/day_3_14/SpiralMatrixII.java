package AutumnPlan_2023.day_3_14;

// @date 2023/3/14
// @time 21:52
// @author zhangzhi
// @description LeetCode 螺旋矩阵 II

import java.util.Arrays;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int loop = n / 2; // 循环几圈
        int mid = n / 2; // 矩阵中间位置单独处理
        int startx = 0;
        int starty = 0;
        int num = 1;
        int offset = 1; // 一圈填充完之后，有边界收缩 1
        int i;
        int j;
        while(loop-- > 0){
            i = startx;
            j = starty;
            // 采用 左闭右开 区间
            // 左 -> 右
            for(;j < n - offset;j++){
                matrix[i][j] = num++;
            }
            // 上 -> 下
            for(;i < n - offset; i++){
                matrix[i][j] = num++;
            }
            // 右 -> 左
            for(;j > starty; j--){
                matrix[i][j] = num++;
            }
            // 下 -> 上
            for(;i > startx; i--){
                matrix[i][j] = num++;
            }

            // 新的 一圈起始位置
            startx++;
            starty++;
            offset++;
        }
        if(n % 2 != 0){
            matrix[mid][mid] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(2)));
    }
}
