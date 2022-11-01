package AutumnPlan_2022.day_10_21;

// @date 2022/10/21
// @time 14:56
// @author zhangzhi
// @description

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BalancedBinaryTree {

    private static int height(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }

    private static boolean dfs(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && dfs(root.left) && dfs(root.right);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {

    }
}
