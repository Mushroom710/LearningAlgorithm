package LeetCodeSpringRecruitment_2022.six_week.day_three;

import java.util.*;

/**
 * @DATE 2022/4/20
 * @TIME 22:22
 * @Created by zhangzhi
 * @description LeetCode 145 题 二叉树的后序遍历
 * 后序遍历可以直接把前序遍历的左右顺序调换一下，最后反转一下 list
 * 就是 后序遍历的结果。
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> solution(TreeNode root){
        if(root == null)return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top.val);
            if (top.left != null)stack.push(top.left);// 调换左右顺序
            if (top.right != null)stack.push(top.right);
        }
        Collections.reverse(list);// 可以把 list 反转
        return list;
    }

    public static void main(String[] args) {

    }
}
