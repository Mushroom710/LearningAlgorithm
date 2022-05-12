package LeetCodeSpringRecruitment_2022.nine_week.day_four;

/**
 * @DATE 2022/5/12
 * @TIME 21:58
 * @Created by zhangzhi
 * @description LeetCode 108 题 将有序数组转换为二叉搜索树
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * @create zhangzhi
     * @date 2022/5/12
     * @time 22:03
     * @description 要根据有序数组构造高度平衡的二叉搜索树
     * 本质就是寻找分割点，分割点作为当前节点，然后递归左区间和右区间
     * 分割点就是数组中间位置的节点
     * 这样左子树和右子树的节点数就比较平均，不会出现不平衡的情况
     */
    public static TreeNode traversal(int[] nums,int left,int right){
        if (left > right)return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums,left,mid - 1);
        root.right = traversal(nums,mid + 1,right);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        if (nums.length == 0)return new TreeNode();
        return traversal(nums,0,nums.length - 1);
    }
}
