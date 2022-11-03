package AutumnPlan_2022.day_11_3;

// @date 2022/11/3
// @time 21:53
// @author zhangzhi
// @description leetcode 59. 螺旋矩阵 II

import java.util.Arrays;

public class SpiralMatrixII {

    /**
     * 求解本题要坚持循环不变量原则。
     * 模拟顺时针画矩阵的过程:
     *    填充上行从左到右
     *    填充右列从上到下
     *    填充下行从右到左
     *    填充左列从下到上
     * 可以发现这里的边界条件非常多，在一个循环中，如此多的边界条件，如果不按照固定规则来遍历，那就是一进循环深似海，从此offer是路人。
     * 这里一圈下来，我们要画每四条边，这四条边怎么画，每画一条边都要坚持一致的左闭右开，或者左开右闭的原则，这样这一圈才能按照统一的规则画下来。
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int loop = n / 2;
        int[][] matrix = new int[n][n];
        int offset = 1;
        int num = 1;
        int startx = 0;
        int starty = 0;
        while (loop-- > 0){
            int i = startx;
            int j = starty;
            // 下面开始的四个for就是模拟转了一圈
            // 模拟填充上行从左到右(左闭右开)
            for(j = starty;j < n - offset;j++){
                matrix[i][j] = num++;
            }
            // 模拟填充右列从上到下(左闭右开)
            for(i = startx;i < n - offset;i++){
                matrix[i][j] = num++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (;j > starty;j--){
                matrix[i][j] = num++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (;i > startx;i--){
                matrix[i][j] = num++;
            }
            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startx++;
            starty++;
            // offset 控制每一圈里每一条边遍历的长度
            offset++;
        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if(n % 2 != 0){
            matrix[n / 2][n / 2] = num;
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] nums = generateMatrix(3);
        System.out.println(Arrays.deepToString(nums));
    }
}
