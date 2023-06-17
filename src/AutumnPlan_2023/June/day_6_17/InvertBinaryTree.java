package AutumnPlan_2023.June.day_6_17;

// @date 2023/6/17
// @time 10:16
// @author zhangzhi
// @description LeetCode 226. 翻转二叉树
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
