package LeetCode;

import java.util.*;

/**
 * @DATE 2022/3/7
 * @Created by zhangzhi
 * @description LeetCode 102 题 二叉树层序遍历
 * 1.广度优先搜索
 *  可以用一个队列实现
 * 2.深度优先搜索
 *  a.直接递归。并用一个 visited 集合记录访问过的结点
 *  b.手动控制递归。
 *  两种方式都需要把当前所在的层数记录下来。访问到相应层结点时
 *  就按对应深度填充到对应数组中
 */

public class BinaryTreeLevelOrderTraversal {

    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/3/7
     * @time 19:44
     * @description 广度优先搜索实现层序遍历
     */
    public static List<List<Integer>> BFS(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        //使用队列来进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);//根结点入队
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();//当前队列的大小得记录下来，不然在for循环里会不断的更新
            for(int i = 0;i<size;i++){//遍历队列中的元素。把孩子结点入队
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/7
     * @time 20:28
     * @param
     * @return a
     * @description DFS 的递归写法有点难处理。主要是这个工具类不太会用
     */
    static int[][] result = new int[2000][];//题目给的限定条件就是2000个结点
    static int max = -1;//记录树的最大深度
    public static List<List<Integer>> solution(TreeNode root){
        if(root == null) {
            return new ArrayList<>();
        }
        int depth = 0;//用于记录当前树的深度。初始为深度为 0。为了方便填充进数组
        DFS(root,depth);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<max;i++){
            List tmp = Arrays.asList(result[i]);
            list.add(tmp);
        }
        return list;
    }

    public static void DFS(TreeNode root,int depth){
        if(root == null){
            return;
        }
        max = Math.max(max, depth);//因为是递归调用，所以depth的值在递归过程中一直在变
        result[depth][0] = root.val;
        DFS(root.left,depth+1);
        DFS(root.right,depth+1);
    }


    public static void main(String[] args) {

    }
}
