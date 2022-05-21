package LeetCodeSpringRecruitment_2022.ten_week.day_six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/5/21
 * @TIME 21:12
 * @Created by zhangzhi
 * @description LeetCode 51 题  N皇后
 * N皇后问题是因为每一行每一列只放一个皇后，
 * 只需要一层 for 循环遍历一行，递归来遍历列，然后一行一列确定皇后的唯一位置。
 */
public class NQueens {
    static List<List<String>> ans;

    /**
     * @create zhangzhi
     * @date 2022/5/21
     * @time 21:23
     * @description 判定当前位置是否可以放置皇后
     */
    public static boolean isValid(int row,int col,char[][] board){
        // 判断列
        for (int i = 0;i < row;i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        // 判断 45° 的方向
        for (int i = row,j = col; i >= 0 && j >= 0;i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // 判断 135° 的方向
        for (int i = row,j = col;i >= 0 && j < board.length;i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/21
     * @time 21:25
     * @description 把字符数组转化为字符串
     */
    public static List<String> charArrToString(char[][] board){
        List<String> list = new ArrayList<>();
        for (char[] chs : board){
            list.add(new String(chs));
        }
        return list;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/21
     * @time 21:25
     * @description 通过 row 来表示层，这样直接就可以选择列
     */
    public static void backtracking(int row,char[][] board){
        if (row == board.length){
            ans.add(charArrToString(board));
            return;
        }
        for (int i = 0;i < board.length;i++){
            if (isValid(row,i,board)){// 判断是否合法
                board[row][i] = 'Q';
                backtracking(row + 1,board);
                board[row][i] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n){
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0;i < n;i++){
            Arrays.fill(board[i],'.');
        }
        backtracking(0,board);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
