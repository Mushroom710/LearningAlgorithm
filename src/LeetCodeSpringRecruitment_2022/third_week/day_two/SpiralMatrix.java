package LeetCodeSpringRecruitment_2022.third_week.day_two;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/3/29
 * @TIME 15:49
 * @Created by zhangzhi
 * @description LeetCode 54 题 螺旋矩阵
 */
public class SpiralMatrix {

    /**
     * @create zhangzhi
     * @date 2022/3/29
     * @time 16:40
     * @description 循环不变量没有拎清楚。所以写的判定语句没有达到要求
     */
    public static List<Integer> solution(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[m][n];
        // 方向数组
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx = 0;// 指示走哪个方向
        int total = m * n; // 矩阵中元素总数
        for(int i = 0; i < total; i++){
            list.add(matrix[row][col]);
            visited[row][col] = true;
             // 这一块的判定写的不好
//            if(col+1 < n&&!visited[row][col+1]){
//                col++;
//            }else if(row+1 < m && !visited[row+1][col]){
//                row++;
//            }else if(col-1 > 0 &&!visited[row][col-1]){
//                col--;
//            }else if (row-1>0 && !visited[row-1][col]){
//                row--;
//            }
            // 计算下下一步走哪
            int nextRow = row + dir[dirIdx][0];
            int nextCol = col + dir[dirIdx][1];
//            if(nextCol < n || nextRow < m || nextCol>0 || nextRow>0 || !visited[nextRow][nextCol])
            // 核心的判定，有一个标准来判定。循环不变量原则
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]){
                dirIdx = (dirIdx + 1) % 4; // 循环方向
            }
            // 走的方向
            row = row + dir[dirIdx][0];
            col = col + dir[dirIdx][1];
        }

        return list;
    }

    public static List<Integer> solution_two(int[][] matrix){
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solution(matrix));
    }
}
