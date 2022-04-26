package LeetCodeSpringRecruitment_2022.seven_week.day_two;

/**
 * @DATE 2022/4/26
 * @TIME 21:53
 * @Created by zhangzhi
 * @description
 */
public class BalancedBinaryTree {

    /**
     * @create zhangzhi
     * @date 2022/4/26
     * @time 22:00
     * @description 分别计算左右子树的高度
     * 如果 abs(left - right) > 1，返回 -1，作为标记
     * 否则，返回当前树的最大高度
     */
    public static int getHeight(TreeNode root){
        if (root == null)return 0;
        int left_height = getHeight(root.left);
        if (left_height == -1)return -1;
        int right_height = getHeight(root.right);
        if (right_height == -1)return -1;

        int result = Math.abs(left_height - right_height);
        if (result > 1){
            return -1;
        }else {
            // 以当前节点为根节点的树的最大高度
            // 为什么呢？因为这是一棵子树，所以需要得到其最大的高度，给上一层的数来比较是不是平衡树
            return 1 + Math.max(left_height , right_height);
        }
    }

    public static boolean solution(TreeNode root){
        return getHeight(root) != -1;
    }

    public static void main(String[] args) {

    }
}
