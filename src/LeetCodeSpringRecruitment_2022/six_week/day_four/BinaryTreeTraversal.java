package LeetCodeSpringRecruitment_2022.six_week.day_four;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @DATE 2022/4/21
 * @TIME 21:19
 * @Created by zhangzhi
 * @description 统一风格的二叉树迭代遍历
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeTraversal {

    /**
     * @create zhangzhi
     * @date 2022/4/21
     * @time 21:31
     * @description 统一风格的迭代遍历
     * 只需要修改中间的添加顺序就可以达成前中后序遍历
     * 从上往下：
     * 前序：右左中
     * 中序：右中左
     * 后序：中右左
     */
    public static List<Integer> PreTraversal(TreeNode root){
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();// 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
            if (node != null){
                node = stack.pop();
                if (node.right != null)stack.push(node.right);// // 添加右节点（空节点不入栈）
                stack.push(node);// 添加中节点
                stack.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.left != null)stack.push(node.left);// 添加左节点（空节点不入栈）
            }else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop();// 将空节点弹出

                node = stack.pop();// 重新取出栈中元素
                list.add(node.val); // 加入到结果集
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
