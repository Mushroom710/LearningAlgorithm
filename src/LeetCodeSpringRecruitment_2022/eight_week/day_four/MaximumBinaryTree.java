package LeetCodeSpringRecruitment_2022.eight_week.day_four;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @DATE 2022/5/5
 * @TIME 21:14
 * @Created by zhangzhi
 * @description LeetCode 654 题 最大二叉树
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

public class MaximumBinaryTree {

    public static TreeNode solution(int[] nums){
        TreeNode node = new TreeNode(0);
        if (nums.length == 1){
            node.val = nums[0];
            return node;
        }
        int maxValue = 0;
        int maxIndex = 0;
        // 找到数组中最大的值和对应的下标
        for (int i = 0;i < nums.length;i++){
            if (nums[i] > maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        node.val = maxValue;
        // 最大值所在的下标左区间 构造左子树
        if (maxIndex > 0){
            int[] left = Arrays.copyOfRange(nums,0,maxIndex);
            node.left = solution(left);
        }
        // 最大值所在的下标右区间 构造右子树
        if (maxIndex < nums.length - 1){
            int[] right = Arrays.copyOfRange(nums,maxIndex + 1,nums.length);
            node.right = solution(right);
        }
        return node;
    }

    public static void show(TreeNode root){
        if (root == null)return;
        System.out.println(root.val);
        show(root.left);
        show(root.right);

    }

    /**
     * @create zhangzhi
     * @date 2022/5/5
     * @time 21:40
     * @description 在左闭右开区间[left, right)，构造二叉树
     */
    public static TreeNode solution_two(int[] nums,int left,int right){
        if (right - left < 1){
            return null;
        }
        TreeNode node = new TreeNode(0);
        if (right - left == 1){
            node.val = nums[left];
            return node;
        }
        int maxValue = nums[left];
        int maxIndex = left;
        // 分割点下标：maxValueIndex
        for (int i = left + 1;i < right;i++){
            if (nums[i] > maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        node.val = maxValue;
        // 左闭右开：[left, maxValueIndex)
        node.left = solution_two(nums,left,maxIndex);
        // 左闭右开：[maxValueIndex + 1, right)
        node.right = solution_two(nums,maxIndex + 1,right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        show(solution(nums));
        show(solution_two(nums,0,nums.length));
    }
}
