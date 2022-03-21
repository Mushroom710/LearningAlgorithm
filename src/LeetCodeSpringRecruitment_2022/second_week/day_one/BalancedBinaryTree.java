package LeetCodeSpringRecruitment_2022.second_week.day_one;

/**
 * @DATE 2022/3/21
 * @TIME 20:30
 * @Created by zhangzhi
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

public class BalancedBinaryTree {

    public static boolean solution(TreeNode root){
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && solution(root.left) && solution(root.right);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {

    }
}
