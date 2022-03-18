package LeetCode;

/**
 * @DATE 2022/3/18
 * @TIME 15:09
 * @Created by zhangzhi
 * @description LeetCode 200 题 岛屿数量
 * 1.采用染色的策略
 *  a.遍历结点
 *      if node == '1'
 *          count++
 *          将 node 和附近相邻的陆地结点置为 '0'
 *          这个过程是一个递归的过程。上下左右递归
 *      else: 不管
 *
 * 2.并查集
 *  a.初始化。每个 '1' 都是自己的 parent
 *  针对所有为 '1' 的结点
 *  b.遍历所有的结点，相邻结点合并
 *      '1' 合并，'0' 不管
 *  c.遍历由几个不同的 parent
 */
public class numberOfIslands {

    /**
     * @create zhangzhi
     * @date 2022/3/18
     * @time 15:30
     * @description 染色的思路
     */
    public static int solution(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                count += DFS(grid,i,j);
            }
        }
        return count;
    }

    private static int DFS(char[][]grid,int i, int j){
        if( i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';

        DFS(grid,i-1,j);    // 上
        DFS(grid,i,j-1);    // 左
        DFS(grid,i,j+1);    // 右
        DFS(grid,i+1,j);    // 下

        return 1;   // 递归找完所有与之相邻的陆地后，才返回 1
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(solution(grid));
    }
}
