package LeetCodeSpringRecruitment_2022.seven_week.day_one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/4/25
 * @TIME 22:00
 * @Created by zhangzhi
 * @description
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

public class MaximumDepthOfBinaryTree {

    public static int solution(TreeNode root){
        if (root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size;i++){
                TreeNode node = queue.poll();
                if (node.left != null)queue.add(node.left);
                if (node.right != null)queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
