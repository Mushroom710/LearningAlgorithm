package AutumnPlan_2023.March.day_3_27;

// @date 2023/3/27
// @time 21:57
// @author zhangzhi
// @description LeetCode 101. 对称二叉树

import java.util.LinkedList;
import java.util.Queue;

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

public class SymmetricTree {

    /**
     * 队列，其实换成其他的容器是一样的效果
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return true;
        }
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || (left.val != right.val)){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    /**
     * 递归法
     */
    private boolean isSym(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        if(!isSym(left.left, right.right)){
            return false;
        }
        if(!isSym(left.right, right.left)){
            return false;
        }
        return left.val == right.val;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left, root.right);
    }
}
