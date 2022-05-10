package LeetCodeSpringRecruitment_2022.nine_week.day_two;

import org.jetbrains.annotations.Nullable;

/**
 * @DATE 2022/5/10
 * @TIME 21:23
 * @Created by zhangzhi
 * @description LeetCode 236 题 二叉树的最近公共祖先
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorOfABinaryTree {

    /**
     * @create zhangzhi
     * @date 2022/5/10
     * @time 21:32
     * @description
     * 二叉树如何可以自底向上查找呢？
     *  回溯啊，二叉树回溯的过程就是从低到上。
     *  后序遍历就是天然的回溯过程，最先处理的一定是叶子节点。
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // 如果找到了 节点p或者q，或者遇到空节点，就返回。
        if (root == p || root == q || root == null)return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // 如果left 和 right都不为空，说明此时root就是最近公共节点。这个比较好理解
        // 说明此时相交与同一个节点，这个节点就是最近公共节点
        if (left != null && right != null)return root;

        // 如果left为空，right不为空，就返回right，说明目标节点是通过right返回的，反之依然。
        if (left == null && right != null){
            return right;
        }else if (left != null && right == null){
            return left;
        }else {// 没得就返回 null
            return null;
        }
    }
}
