package AutumnPlan_2023.March.day_3_25;

// @date 2023/3/25
// @time 22:09
// @author zhangzhi
// @description LeetCode 94. 二叉树的中序遍历

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    private static void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root,list);
        return list;
    }
}
