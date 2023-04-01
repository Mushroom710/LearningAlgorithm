package AutumnPlan_2023.March.day_3_26;

// @date 2023/3/26
// @time 21:29
// @author zhangzhi
// @description LeetCode 102. 二叉树的层序遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
