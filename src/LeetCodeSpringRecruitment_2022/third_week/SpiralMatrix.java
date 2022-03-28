package LeetCodeSpringRecruitment_2022.third_week;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/3/28
 * @TIME 11:33
 * @Created by zhangzhi
 * @description LeetCode 54 题 螺旋矩阵
 */
public class SpiralMatrix {

    public static List<Integer> solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        int startx = 0;
        int starty = 0;
        int offset = 1;
        int loop = m / 2;
        int mid = m / 2;
        while (loop > 0){
            int i = startx;
            int j = starty;
            for(;j < starty + m - offset; j++){
                list.add(matrix[i][j]);
            }
            for(;i < startx + n - offset; i++){
                list.add(matrix[i][j]);
            }
            for(;j > starty; j--){
                list.add(matrix[i][j]);
            }
            for(;i > startx; i--){
                list.add(matrix[i][j]);
            }
            startx++;
            starty++;
            offset +=2;
            loop--;
        }
        if(m % 2 == 1){
            list.add(matrix[mid][mid]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solution(matrix));
    }
}
