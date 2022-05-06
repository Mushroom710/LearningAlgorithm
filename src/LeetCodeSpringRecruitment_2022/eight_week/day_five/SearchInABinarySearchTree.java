package LeetCodeSpringRecruitment_2022.eight_week.day_five;

/**
 * @DATE 2022/5/6
 * @TIME 21:47
 * @Created by zhangzhi
 * @description
 */
public class SearchInABinarySearchTree {

    /**
     * @create zhangzhi
     * @date 2022/5/6
     * @time 21:55
     * @description 递归法 -- 其实还是使用到二叉搜索树的特性
     */
    public static TreeNode solution(TreeNode root,int val){
        // 如果root为空，或者找到这个数值了，就返回root节点。
        if (root == null || root.val == val)return root;
        // 如果root->val > val，搜索左子树
        if (root.val > val)return solution(root.left,val);
        // 如果root->val < val，搜索右子树
        if (root.val < val)return solution(root.right,val);
        return null;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/6
     * @time 21:54
     * @description 迭代法 --- 根据二叉搜索树的特性
     */
    public static TreeNode solution_two(TreeNode root,int val){
        while (root != null){
            if (root.val == val){// 找到就直接返回
                return root;
            }else if (root.val > val){// 大于就找左子树
                root = root.left;
            }else { // 否则找右子树
                root = root.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
