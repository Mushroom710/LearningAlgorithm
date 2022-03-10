package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/3/10
 * @Created by zhangzhi
 * @description LeetCode 22 题 生成有效括号组合
 * 1.DFS
 *  a.n给定时，字符串的长度也确定为 2*n
 *  b.等同于在 2*n 的数组中填充括号
 */
public class generateParentheses {

    public static List<String> solution(int n){
        List<String> list = new ArrayList<>();
        dfs(0,0,n,list,"");
        return list;
    }

    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/3/10
     * @time 10:29
     * @description 采用深搜的方式解决
     * 一个显然的条件是，一定是先有左括号，然后才有右括号。
     * 这可以作为一个递归条件使用
     */
    public static void dfs(int left,int right,int n,List<String> list,String result){
        if(left == n && right == n){// 左右括号全部用完。这是就生成了一个括号组合
            list.add(result);
            return;
        }
        if(left < n){// 左括号没用完
            dfs(left+1,right,n,list,result+"(");
        }
        if(left > right && right < n){// 左括号的个数得大于右括号，同时右括号的个数得小于 n
            dfs(left,right+1,n,list,result+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
    }
}
