package LeetCodeSpringRecruitment_2022.nine_week.day_two;

/**
 * @DATE 2022/5/10
 * @TIME 21:54
 * @Created by zhangzhi
 * @description LeetCode 235 题 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * @create zhangzhi
     * @date 2022/5/10
     * @time 22:02
     * @description
     * 在遍历二叉搜索树的时候就是寻找区间[p->val, q->val]（注意这里是左闭又闭）
     *  那么如果 root->val 大于 p->val，同时 root->val 大于q->val，
     *  那么就应该向左遍历（说明目标区间在左子树上）。
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)return null;

        // 如果 root->val 小于 p->val，同时 root->val 小于 q->val，
        // 那么就应该向右遍历（目标区间在右子树）。
        if (root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            if (left != null){
                return left;
            }
        }
        // 否则向右
        if (root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if (right != null){
                return right;
            }
        }
        // 剩下的情况，就是root节点在区间（p->val <= root->val && root->val <= q->val）
        // 或者
        // （q->val <= root->val && root->val <= p->val）中，
        // 那么root就是最近公共祖先了，直接返回root。
        // 在区间里，直接返回即可
        return root;
    }
}
