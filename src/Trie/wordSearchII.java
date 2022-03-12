package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @DATE 2022/3/12
 * @TIME 10:10
 * @Created by zhangzhi
 * @description LeetCode 212 题 二维网格中单词搜索问题
 * 1.DFS
 *  枚举每一个字母，按上下左右进行递归
 * 2.Trie。使用字典树
 *  用 Trie 进行快速定位，然后对找到的字符进行 DFS
 */
public class wordSearchII {
    static Set<String> res = new HashSet<>();
    public static List<String> findwords(char[][] board,String[] words){
        Trie trie = new Trie();// 用字典树
        for(String word : words){// 添加进字典树
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];// 标记数组
        for(int i = 0;i<m;i++){// 递归遍历二维网格
            for(int j = 0;j<n;j++){
                dfs(board,visited,"",i,j,trie);
            }
        }
        return new ArrayList<>(res);
    }

    private static void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if(x<0 || x >= board.length || y<0 || y>=board[0].length){// 判断是否越界
            return;
        }
        if(visited[x][y]){// 是否引进访问过
            return;
        }
        str += board[x][y];// 添加字符
        if(!trie.startsWith(str)){// 查看Trie中是否有前缀
            return;
        }
        if(trie.search(str)){// 查看是否找到一个单词
            res.add(str);
        }
        visited[x][y] = true;// 标记该位置

        dfs(board,visited,str,x-1,y,trie);// 上下左右递归找
        dfs(board,visited,str,x+1,y,trie);
        dfs(board,visited,str,x,y-1,trie);
        dfs(board,visited,str,x,y+1,trie);

        visited[x][y] = false;// 解除标记
    }

    public static void main(String[] args) {

    }
}
