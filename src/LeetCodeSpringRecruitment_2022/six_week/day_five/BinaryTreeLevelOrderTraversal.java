package LeetCodeSpringRecruitment_2022.six_week.day_five;

import java.util.*;

/**
 * @DATE 2022/4/22
 * @TIME 21:09
 * @Created by zhangzhi
 * @description LeetCode 102 题 二叉树的层序遍历
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> solution(TreeNode root){
        if (root == null)return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 这里一定要使用固定大小size，不要使用que.size()，
            // 因为que.size是不断变化的
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size;i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)queue.add(node.left);
                if (node.right != null)queue.add(node.right);
            }
            ans.add(tmp);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
