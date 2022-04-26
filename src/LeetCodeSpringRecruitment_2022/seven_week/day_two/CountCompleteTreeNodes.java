package LeetCodeSpringRecruitment_2022.seven_week.day_two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DATE 2022/4/26
 * @TIME 21:17
 * @Created by zhangzhi
 * @description LeetCode 222 题 完全二叉树的节点个数
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

public class CountCompleteTreeNodes {

    /**
     * @create zhangzhi
     * @date 2022/4/26
     * @time 21:24
     * @description 递归法
     */
    public static int solution(TreeNode root){
        if (root == null)return 0;
        int left = solution(root.left); // 左
        int right = solution(root.right); // 右
        return left + right + 1; // 中
    }

    /**
     * @create zhangzhi
     * @date 2022/4/26
     * @time 21:25
     * @description 使用队列
     */
    public static int solution_two(TreeNode root){
        if (root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for (int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if (node.left != null)queue.add(node.left);
                if (node.right != null)queue.add(node.right);
            }
        }
        return count;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/26
     * @time 21:33
     * @description 根据完全二叉树的性质来统计
     * 完全二叉树，必定会有其子树是满二叉树
     * 这个时候就可以用公式：2^n - 1 来计算节点个数
     */
    public static int solution_three(TreeNode root){
        if (root == null)return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int left_height = 0;
        int right_height = 0;
        while (left != null){// 左子树深度
            left = left.left;
            left_height++;
        }
        while (right != null){// 右子树深度
            right = right.right;
            right_height++;
        }
        if (left_height == right_height){ // 如果深度一致，说明是该子树是满二叉树
            return (2 << left_height) - 1;
        }
        // 否则，分别向左右子树递归，顺便把中间的节点加上
        return solution_three(root.left) + solution_three(root.right) + 1;
    }

    public static void main(String[] args) {

    }
}
