package AutumnPlan_2023.May.day_5_31;

// @date 2023/5/31
// @time 9:32
// @author zhangzhi
// @description LeetCode 235. 二叉搜索树的最近公共祖先

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(true){
            int val = cur.val;
            if(p.val > val && q.val > val){
                cur = cur.right;
            }else if(p.val < val && q.val < val){
                cur = cur.left;
            }else{
                return cur;
            }
        }
    }
}
