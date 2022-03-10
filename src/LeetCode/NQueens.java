package LeetCode;

import java.util.*;

/**
 * @DATE 2022/3/10
 * @Created by zhangzhi
 * @description LeetCode 51 52 题 N皇后问题
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.'
 * 分别代表了皇后和空位。
 * 1.DFS 深度搜索 解决
 *  解决的关键在于怎么判定当前位置是否可以放置皇后
 *  思路：
 *  写一个DFS，按照每一层进行遍历，遍历当前层，循环 j 也就是列，循环是判断当前 [i,j]
 *  是否满足没有之前皇后对她有攻击。如果没有，就把皇后放下去，之后，把她所在的位置产生的col、pie、na
 *  产生的效果赋成 1。如果当前位置被占。就 DFS 走到下一层(level + 1)
 *  同时注意，当前层做完工作后，要恢复到之前的状态
 */
public class NQueens {
    public static List<List<String>> solveNQueens(int n){
        if(n < 1)return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();// 记录列的状态
        Set<Integer> pie = new HashSet<>();// 记录pie的状态 即 x+y = c
        Set<Integer> na = new HashSet<>();// 记录na的状态 即 y-x = c
        DFS(result,n,0,cols,pie,na,new int[n]);
        return result;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/10
     * @time 19:39
     * @description 用于递归每一行在哪个位置放置皇后
     * cur_state数组用于保存每一行放置皇后的位置。
     * 以下标为 row ，值为 col
     */
    public static void DFS(List<List<String>> result,int n,int row,Set<Integer> cols,Set<Integer> pie,Set<Integer> na,int[] cur_state){
        if( row >= n){
            result.add(_conversion(n,cur_state));
            return;
        }
        for(int col = 0; col < n; col++){
            if(cols.contains(col) || pie.contains(row + col) || na.contains(row - col)){
                continue;
            }
            cols.add(col);// 找到皇后放置的位置后，更新状态
            pie.add(row + col);
            na.add(row - col);
            cur_state[row] = col;
            DFS(result,n,row + 1,cols,pie,na,cur_state);
            cols.remove(col);// 一层递归完成后，还原状态
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/10
     * @time 19:38
     * @description 用于生成最后的字符数组
     * [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
     */
    public static List<String> _conversion(int n,int[] cur_state){
        List<String> board = new ArrayList<>();
        for(int i = 0;i<n;i++){
            char[] chs = new char[n];
            Arrays.fill(chs,'.');// 初始化填充的字符
            chs[cur_state[i]] = 'Q';
            board.add(new String(chs));
        }
        return board;
    }
    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}
