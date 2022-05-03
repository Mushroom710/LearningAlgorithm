package LeetCodeSpringRecruitment_2022.eight_week.day_two;

import java.util.Arrays;

/**
 * @DATE 2022/5/3
 * @TIME 21:10
 * @Created by zhangzhi
 * @description LeetCode 106 题 从中序与后序遍历序列构造二叉树
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

public class ConstructBinaryTreefromInorderAndPostorderTraversal {

    /**
     * @create zhangzhi
     * @date 2022/5/3
     * @time 21:41
     * @description 通过中序和后序创建二叉树
     */
    public static TreeNode recursion(int[] inorder, int[] postorder){
        if (postorder.length == 0)return null;

        // 从后序的数组中取出最后一个元素，作为根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1)return root;

        int idx = 0;
        // 找到这个节点在中序的下标，好把中序数组分为左中序和右中序两部分
        for (;idx < inorder.length;idx++){
            if (inorder[idx] == postorder[postorder.length - 1]){
                break;
            }
        }

        // 注意分割原则，左闭右开或者左闭右闭
        int[] left_inorder = Arrays.copyOfRange(inorder,0,idx);
        int[] right_inorder = Arrays.copyOfRange(inorder,idx + 1,inorder.length);

        int[] left_postorder = Arrays.copyOfRange(postorder,0,left_inorder.length);
        // 这里减一的原因是因为最后一个已经被用作根节点了
        int[] right_postorder = Arrays.copyOfRange(postorder,left_inorder.length,postorder.length - 1);

        root.left = recursion(left_inorder,left_postorder);
        root.right = recursion(right_inorder,right_postorder);
        return root;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/3
     * @time 22:08
     * @description 根据前序和中序遍历生成二叉树
     */
    public static TreeNode recursion_two(int[] preorder, int[] inorder){
        if (preorder.length == 0)return null;

        // 从后序的数组中取出最后一个元素，作为根节点
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1)return root;

        int idx = 0;
        // 找到这个节点在中序的下标，好把中序数组分为左中序和右中序两部分
        for (;idx < inorder.length;idx++){
            if (inorder[idx] == preorder[0]){
                break;
            }
        }

        // 注意分割原则，左闭右开或者左闭右闭
        int[] left_inorder = Arrays.copyOfRange(inorder,0,idx);
        int[] right_inorder = Arrays.copyOfRange(inorder,idx + 1,inorder.length);

        // 为什么都是 idx + 1 呢
        // 左闭右开原则
        int[] left_preorder = Arrays.copyOfRange(preorder,1,idx + 1);
        int[] right_preorder = Arrays.copyOfRange(preorder,idx + 1,preorder.length);

        root.left = recursion_two(left_preorder,left_inorder);
        root.right = recursion_two(right_preorder,right_inorder);
        return root;
    }

    public static TreeNode solution(int[] inorder, int[] postorder){
        return recursion(inorder,postorder);
    }

    public static void show(TreeNode root){
        if (root == null)return;
        show(root.left);
        System.out.println(root.val);
        show(root.right);

    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        show(recursion(inorder,postorder));
        int[] preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        show(recursion_two(preorder,inorder));
    }
}
