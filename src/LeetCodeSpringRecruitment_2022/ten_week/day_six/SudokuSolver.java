package LeetCodeSpringRecruitment_2022.ten_week.day_six;

/**
 * @DATE 2022/5/21
 * @TIME 21:32
 * @Created by zhangzhi
 * @description LeetCode 37 题 解数独
 * 你可以假设给定的数独只有唯一解。
 * 所以只需要在递归树中找到一个解就可以直接返回
 */
public class SudokuSolver {

    public static boolean isValid(int row,int col,char val,char[][] board){
        for (int i = 0;i < 9;i++){// 判断行里是否重复
            if (board[row][i] == val){
                return false;
            }
        }
        for (int j = 0;j < 9;j++){// 判断列里是否重复
            if (board[j][col] == val){
                return false;
            }
        }

        int startRow = (row / 3) * 3;// 这个技巧性很强，一个难点就在这，怎么定位当前格子在哪个九宫格里
        int startCol = (col / 3) * 3;
        for (int i = startRow;i < startRow + 3;i++){// 判断9方格里是否重复
            for (int j = startCol;j < startCol + 3;j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean backtracking(char[][] board){
        // 一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！
        for (int i = 0;i < 9;i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){// 跳过原始数字
                    continue;
                }
                for (char ch = '0'; ch <= '9'; ch++){
                    if (isValid(i,j,ch,board)){
                        board[i][j] = ch;
                        if(backtracking(board)) {// 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
                return false;// 9 个数都不行，返回 false
            }
        }
        return true;// 遍历完没有返回false，说明找到了合适棋盘位置了
    }

    public static void solveSudoku(char[][] board){
        backtracking(board);
    }

    public static void main(String[] args) {

    }
}
