package AutumnPlan_2023.day_3_25;

// @date 2023/3/25
// @time 22:08
// @author zhangzhi
// @description LeetCode 145. 二叉树的后序遍历

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    private static void postOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postOrder(root,list);
        return list;
    }
}
