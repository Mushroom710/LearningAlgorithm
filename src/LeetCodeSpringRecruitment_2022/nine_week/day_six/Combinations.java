package LeetCodeSpringRecruitment_2022.nine_week.day_six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/5/14
 * @TIME 21:26
 * @Created by zhangzhi
 * @description LeetCode 77 题 组合
 * 回溯法解决的问题都可以抽象为树形结构（N叉树），用树形结构来理解回溯就容易多了。
 * for循环横向遍历，递归纵向遍历，回溯不断调整其结果集
 * 图中每次搜索到了叶子节点，我们就找到了一个结果。
 * 递归来做层叠嵌套（可以理解是开 k 层 for 循环），
 * 每一次的递归中嵌套一个 for 循环，那么递归就可以用于解决多层嵌套循环的问题了。
 */
public class Combinations {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int n,int k,int startIdx){
        if (path.size() == k){
            ans.add(new ArrayList<>(path));// 注意，path 是全局变量，需要重新生成一个对象，不然后面会被修改
            return;
        }
        // 一点优化：剪枝
        //  1.已经选择的元素个数：path.size();
        //  2.还需要的元素个数为: k - path.size();
        //  3.在集合n中至多要从该起始位置 : n --> n - (k - path.size()) + 1，开始遍历
        // 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        for (int i = startIdx;i <= n;i++){
            path.add(i);
            backtracking(n,k,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(n,k,1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(combine(100, 50).toArray()));
    }
}
