package LeetCodeSpringRecruitment_2022.eight_week.day_five;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/5/6
 * @TIME 21:28
 * @Created by zhangzhi
 * @description LeetCode 617 题 合并二叉树
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

public class MergeTwoBinaryTrees {

    public static TreeNode solution(TreeNode root1, TreeNode root2){
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }

        root1.val += root2.val;
        root1.left = solution(root1.left,root2.left);
        root1.right = solution(root1.right, root2.right);
        return root1;
    }

    public static TreeNode solution_two(TreeNode root1, TreeNode root2){
        if (root1 == null)return root2;
        if (root2 == null)return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val += node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null){
                queue.add(node1.left);
                queue.add(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null){
                queue.add(node1.right);
                queue.add(node2.right);
            }
            // 当 root1 的左节点 为空 root2 左节点不为空，就赋值过去
            if (node1.left == null && node2.left != null){
                node1.left = node2.left;
            }
            // 当 root1 的右节点 为空 root2 右节点不为空，就赋值过去
            if (node1.right == null && node2.right != null){
                node1.right = node2.right;
            }
        }
        return root1;
    }

    public static void main(String[] args) {

    }
}
