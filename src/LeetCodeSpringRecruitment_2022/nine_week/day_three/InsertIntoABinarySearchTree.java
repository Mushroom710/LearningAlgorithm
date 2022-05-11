package LeetCodeSpringRecruitment_2022.nine_week.day_three;

/**
 * @DATE 2022/5/11
 * @TIME 21:13
 * @Created by zhangzhi
 * @description LeetCode 701 题 二叉搜索树中的插入操作
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

public class InsertIntoABinarySearchTree {

    /**
     * @create zhangzhi
     * @date 2022/5/11
     * @time 21:17
     * @description 递归有返回值
     * 需要使用搜索树的特性，有方向的递归
     *
     * 如何通过递归函数返回值完成了新加入节点的父子关系赋值操作了，下一层将加入节点返回，
     * 本层用 root->left 或者 root->right 将其接住。
     */
    public static TreeNode insertIntoBST(TreeNode root, int val){
        // 为 null 时，说明找到了插入位置，在上一层完成接收
        if (root == null)return new TreeNode(val);
        // 搜索树是有方向了，可以根据插入元素的数值，决定递归方向。
        if (root.val > val)root.left = insertIntoBST(root.left,val);
        if (root.val < val)root.right = insertIntoBST(root.right,val);
        return root;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/11
     * @time 21:28
     * @description 递归无返回值，那么就需要一个 parent 节点来记录父节点
     */
    static TreeNode parent;
    public static void traversal(TreeNode root,int val){
        if (root == null){
            // 没有返回值，需要记录上一个节点（parent），遇到空节点了，
            // 就让 parent 左孩子或者右孩子指向新插入的节点。然后结束递归。
            TreeNode node = new TreeNode(val);
            if (parent.val > val)parent.left = node;
            else parent.right = node;
            return;
        }
        parent = root;// 记录父节点
        // 搜索树是有方向了，可以根据插入元素的数值，决定递归方向。
        if (root.val > val)traversal(root.left,val);
        if (root.val < val)traversal(root.right,val);
    }

    public static TreeNode solution(TreeNode root,int val){
        if (root == null)return new TreeNode(val);
        parent = null;
        traversal(root,val);
        return root;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/11
     * @time 21:29
     * @description 迭代法
     */
    public static TreeNode solution_two(TreeNode root,int val){
        if (root == null)return new TreeNode(val);
        TreeNode pre = root;// 这个很重要，需要记录上一个节点，否则无法赋值新节点
        TreeNode cur = root;
        // 当找到空节点时，说明找到了插入位置
        while (cur != null){
            pre = cur;
            if (cur.val > val)cur = cur.left;
            else cur = cur.right;
        }
        // 此时是用 pre 节点的进行赋值
        if (pre.val > val)pre.left = new TreeNode(val);
        else pre.right = new TreeNode(val);
        return root;
    }
}
