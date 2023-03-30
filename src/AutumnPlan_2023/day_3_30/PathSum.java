package AutumnPlan_2023.day_3_30;

// @date 2023/3/30
// @time 22:06
// @author zhangzhi
// @description LeetCode 112. 路径总和

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
public class PathSum {

    private boolean getSum(TreeNode root, int targetSum, int curSum){
        if(root.left == null && root.right == null && targetSum == curSum){
            //System.out.println(curSum);
            return true;
        }
        if(root.left == null && root.right == null){
            return false;
        }
        // 空节点不入栈
        if(root.left != null){
            if(getSum(root.left, targetSum, curSum + root.left.val)){
                return true;
            }
        }
        if(root.right != null){
            if(getSum(root.right, targetSum, curSum + root.right.val)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return getSum(root, targetSum, root.val);
    }
}
