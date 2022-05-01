package LeetCodeSpringRecruitment_2022.seven_week.day_four;

import java.util.Stack;

/**
 * @DATE 2022/4/28
 * @TIME 21:50
 * @Created by zhangzhi
 * @description LeetCode 404 题 左叶子之和
 * 选择递归顺序很重要
 */
public class SumOfLeftLeaves {

    public static int solution(TreeNode root){
        if (root == null)return 0;

        int left = solution(root.left);// 左子树的左叶子节点之和
        int right = solution(root.right);// 右子树的左叶子节点之和

        int mid = 0;
        // 左叶子节点的判定规则
        // 1.当前节点的左节点不为空
        // 2.当前节点的左节点的左节点为空
        // 3.当前节点的左节点的右节点为空
        if (root.left != null && root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }

        return mid + left + right;// 累加左子树和右子树求取左叶子数值之和
    }

    /**
     * @create zhangzhi
     * @date 2022/4/28
     * @time 21:58
     * @description 迭代法使用前中后序都是可以的
     */
    public static int solution_two(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null){
                sum += node.left.val;
            }
            if (node.left != null)stack.push(node.left);
            if (node.right != null)stack.push(node.right);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
