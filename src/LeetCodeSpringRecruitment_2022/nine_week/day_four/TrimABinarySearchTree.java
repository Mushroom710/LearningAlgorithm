package LeetCodeSpringRecruitment_2022.nine_week.day_four;

/**
 * @DATE 2022/5/12
 * @TIME 21:24
 * @Created by zhangzhi
 * @description LeetCode 669 题 修剪二叉搜索树
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

public class TrimABinarySearchTree {

    public static TreeNode trimBST(TreeNode root, int low, int high){
        // 空节点直接返回
        if (root == null)return null;
        // 删除节点
        // 如果找到一个不在 [low,high] 节点
        // 就需要按一定的策略去找满足条件的节点，替换掉这个不满足条件的节点
        // root.val < low 说明需要向右子树找一个满足条件的节点并返回
        if (root.val < low)return trimBST(root.right,low,high);
        // root.val > high 说明需要向左子树找一个满足条件的节点并返回
        if (root.val > high)return trimBST(root.left,low,high);
        // 接下来要将下一层处理完左子树的结果赋给root->left，处理完右子树的结果赋给root->right。
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

    public static TreeNode solution(TreeNode root, int low, int high){
        if (root == null)return null;
        // 处理头结点，让 root 移动到 [low, high] 范围内，注意是左闭右闭
        while (root != null && (root.val < low || root.val > high)){
            if (root.val < low)root = root.right;
            else root = root.left;
        }
        TreeNode cur = root;
        // 此时 root 已经在 [low, high] 范围内，处理左孩子元素小于 low 的情况
        while (cur != null){
            while (cur.left != null && cur.left.val < low){
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;
        // 此时 root 已经在 [low, high] 范围内，处理右孩子大于 high 的情况
        while (cur != null){
            while (cur.right != null && cur.right.val > high){
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        solution(root,1,1);
    }
}
