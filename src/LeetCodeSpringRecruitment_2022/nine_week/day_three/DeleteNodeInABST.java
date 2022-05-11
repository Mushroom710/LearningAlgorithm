package LeetCodeSpringRecruitment_2022.nine_week.day_three;

/**
 * @DATE 2022/5/11
 * @TIME 21:47
 * @Created by zhangzhi
 * @description LeetCode 450 题 删除二叉搜索树中的节点
 */
public class DeleteNodeInABST {

    /**
     * @create zhangzhi
     * @date 2022/5/11
     * @time 22:06
     * @description 删除节点需要考虑的情况有点多，所以需要有一个策略来找出所有可能的情况
     */
    public static TreeNode deleteNode(TreeNode root, int key){
        // 第一种情况：没找到删除的节点，遍历到空节点直接返回了
        if (root == null)return null;
        if (root.val == key){
            // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            if (root.left == null && root.right == null){
                return null;
            }else if (root.left == null){// 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
                return root.right;
            }else if (root.right == null){// 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
                return root.left;
            }else {
                // 想不明白的话，就画个图来理解
                // 左右孩子节点都不为空，
                // 则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，
                // 返回删除节点右孩子为新的根节点。
                TreeNode cur = root.right;// 找右子树最左面的节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;// 把要删除的节点（root）左子树放在cur的左孩子的位置
                root = root.right;// 返回旧root的右孩子作为新root
                return root;
            }
        }
        if (root.val > key)root.left = deleteNode(root.left,key);
        if (root.val < key)root.right = deleteNode(root.right,key);
        return root;
    }
}
