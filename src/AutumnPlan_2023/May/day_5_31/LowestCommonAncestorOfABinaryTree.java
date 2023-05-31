package AutumnPlan_2023.May.day_5_31;

// @date 2023/5/31
// @time 9:31
// @author zhangzhi
// @description LeetCode 236. 二叉树的最近公共祖先
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
    }
}
