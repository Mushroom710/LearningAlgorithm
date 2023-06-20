package AutumnPlan_2023.June.day_6_20;

// @date 2023/6/20
// @time 10:42
// @author zhangzhi
// @description LeetCode 235. 二叉搜索树的最近公共祖先
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
