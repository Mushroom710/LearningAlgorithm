package LeetCode.SudokuProblem;

import java.util.Arrays;

/**
 * @DATE 2022/3/11
 * @Created by zhangzhi
 * @description LeetCode 37 题 解数独
 * 解题关键：怎么标记已经出现的数？怎么判重？
 * 1.DFS 深搜
 * DFS(i,j) 枚举每一个空格子
 * a.先 j+1 -> j+1 > 9 -> i+1,j=0
 * loop: 1-9    枚举 1-9
 * check_valid  检查是否合法
 * 2.加速
 * 1.先从行/列 空格子少的开始枚举
 * 2.预处理。用 N*N 矩阵记录可选数的个数
 * 遍历矩阵，找到每一个空格子的可选数。根据可选数的个数进行排序。
 * 从小到大进行排序。之后对这些空格子进行 DFS
 * DFS(i,j)
 * loop: 可选数
 * check_valid
 */
public class SudokuSolver {

    public static void solveSudoKu(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    /**
     * @create zhangzhi
     * @date 2022/3/11
     * @time 14:45
     * @description 枚举矩阵的每一个空格
     */
    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) { // 枚举行
            for (int j = 0; j < board[0].length; j++) { // 枚举 列
                if (board[i][j] == '.') {// 判断是否是空格
                    for (char c = '1'; c <= '9'; c++) {// 枚举 1 - 9
                        if (isvalid(board, i, j, c)) {// 判断填入的数是否有效
                            board[i][j] = c;
                            if (solve(board)) {// 有效就向下递归
                                return true;
                            } else {// 无效就还原状态
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/11
     * @time 14:47
     * @description 判断填入的数是否有效
     */
    public static boolean isvalid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {// 检查行 row
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) { // 检查列 col
                return false;
            }
            // 检查每一个 3*3 的小宫格
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoKu(board);
        for (char[] chs : board) {
            System.out.println(Arrays.toString(chs));
        }
    }
}
