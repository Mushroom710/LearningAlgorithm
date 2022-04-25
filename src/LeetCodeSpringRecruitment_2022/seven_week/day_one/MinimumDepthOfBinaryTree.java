package LeetCodeSpringRecruitment_2022.seven_week.day_one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/4/25
 * @TIME 22:13
 * @Created by zhangzhi
 * @description
 */
public class MinimumDepthOfBinaryTree {

    public static int solution(TreeNode root){
        if (root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                // 找到一个左右孩子都为空的节点，这个时候就说明这个节点就是二叉树的最小深度所在
                if (node.left == null && node.right == null) {
                    return depth++;
                }
                if (node.left != null)queue.add(node.left);
                if (node.right != null)queue.add(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
