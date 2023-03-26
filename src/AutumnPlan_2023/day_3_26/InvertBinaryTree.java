package AutumnPlan_2023.day_3_26;

// @date 2023/3/26
// @time 22:08
// @author zhangzhi
// @description LeetCode 226. 翻转二叉树
// 一看就会，一做就废。

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }
}
