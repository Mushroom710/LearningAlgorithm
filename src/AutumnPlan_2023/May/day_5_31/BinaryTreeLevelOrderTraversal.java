package AutumnPlan_2023.May.day_5_31;

// @date 2023/5/31
// @time 9:00
// @author zhangzhi
// @description LeetCode 102. 二叉树的层序遍历

import java.util.*;

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

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                tmp.add(node.val);
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
