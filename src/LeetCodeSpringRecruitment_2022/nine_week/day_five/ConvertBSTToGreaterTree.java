package LeetCodeSpringRecruitment_2022.nine_week.day_five;

import java.util.Stack;

/**
 * @DATE 2022/5/13
 * @TIME 20:26
 * @Created by zhangzhi
 * @description LeetCode 538 题 把二叉搜索树转换为累加树
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

public class ConvertBSTToGreaterTree {

    /**
     * @create zhangzhi
     * @date 2022/5/13
     * @time 20:39
     * @description 如果把这道题换成数组，那就很容易了，只需要从后向前遍历即可
     * 那么对于树来说，就是需要反中序遍历了，右中左！
     */
    static int pre;
    public static void traversal(TreeNode root){
        if (root == null)return;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
    public static TreeNode convertBST(TreeNode root){
        pre = 0;
        traversal(root);
        return root;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/13
     * @time 20:38
     * @description 迭代法都快忘了，赶紧复习一波
     * 没想到迭代法居然超出内存了
     */
    public static void traversal_two(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(root);
                cur = cur.right;
            }else {
                cur = stack.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;
            }
        }
    }
    public static TreeNode solution(TreeNode root){
        pre = 0;
        traversal_two(root);
        return root;
    }
}
