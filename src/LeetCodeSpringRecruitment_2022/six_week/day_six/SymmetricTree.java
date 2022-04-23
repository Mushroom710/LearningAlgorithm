package LeetCodeSpringRecruitment_2022.six_week.day_six;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/4/23
 * @TIME 21:20
 * @Created by zhangzhi
 * @description LeetCode 101 题 对称二叉树
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

public class SymmetricTree {

    public static boolean solution(TreeNode root){
        if (root == null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            // 两个都是空结点，跳过
            if (n1 == null && n2 == null)continue;

            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
            if (n1 == null || n2 == null || n1.val != n2.val)return false;

            // 注意入队顺序
            // 左节点的左孩子，右节点的右孩子
            queue.add(n1.left);
            queue.add(n2.right);
            // 左节点的右孩子，右节点的左孩子
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
