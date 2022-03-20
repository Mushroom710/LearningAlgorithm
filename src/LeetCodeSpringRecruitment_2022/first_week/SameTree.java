package LeetCodeSpringRecruitment_2022.first_week;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/3/20
 * @TIME 17:54
 * @Created by zhangzhi
 * @description LeetCode 100 题 相同的树
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree {

    public static boolean solution(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return dfs(p,q);
        }
        return false;
    }

    public static boolean dfs(TreeNode p,TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode n1 = queue.poll();
                TreeNode n2 = queue.poll();
                if(n1.val != n2.val){
                    return false;
                }
                if(n1.left != null && n2.left != null){
                    queue.add(n1.left);
                    queue.add(n2.left);
                }else {
                    return false;
                }
                if(n1.right != null && n2.right != null){
                    queue.add(n1.right);
                    queue.add(n2.right);
                }
            }
        }
        return true;
    }


    /**
     * @create zhangzhi
     * @date 2022/3/20
     * @time 18:22
     * @description LeetCode 官方题解
     * 深度优先搜索
     */
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

    public static boolean solution2(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()){
            int size = queue.size()/2;
            for(int i = 0; i<size ; i++){
                TreeNode n1 = queue.poll();
                TreeNode n2 = queue.poll();
                if(n1.val != n2.val){
                    return false;
                }
                if(n1.left == null || n2.left == null){
                    return false;
                }else if(n1.left != null && n2.left != null){
                    queue.add(n1.left);
                    queue.add(n2.left);
                }

                if(n1.right == null || n2.right == null){
                    return false;
                }else if(n1.right != null && n2.right != null){
                    queue.add(n1.left);
                    queue.add(n2.left);
                }
            }
        }
        return true;
    }

}
