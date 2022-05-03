package LeetCodeSpringRecruitment_2022.eight_week.day_one;

/**
 * @DATE 2022/5/2
 * @TIME 21:31
 * @Created by zhangzhi
 * @description LeetCode 112 题 路径总和
 * 明确递归什么时候需要返回值，什么时候不需要
 */

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

    public static boolean recursion(TreeNode root,int targetsum){
        // 遇到叶子节点，并且 targetsum == 0 说明有一条路径
        if (root.left == null && root.right == null && targetsum == 0)return true;
        // 遇到叶子节点，但是 targetsum 并没有减到 0
        if (root.left == null && root.right == null)return false;
        if (root.left != null){// 节点为空不递归
            if (recursion(root.left,targetsum - root.left.val))return true;
        }
        if (root.right != null){
            return recursion(root.right, targetsum - root.right.val);
        }
        return false;
    }

    public static boolean solution(TreeNode root,int targetSum){
        if (root == null)return false;
        return recursion(root,targetSum - root.val);
    }

    public static void main(String[] args) {

    }
}
