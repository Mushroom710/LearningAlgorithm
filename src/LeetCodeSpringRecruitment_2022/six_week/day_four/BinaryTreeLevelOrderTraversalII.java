package LeetCodeSpringRecruitment_2022.six_week.day_four;

import java.util.*;

/**
 * @DATE 2022/4/22
 * @TIME 21:26
 * @Created by zhangzhi
 * @description LeetCode 107 题 二叉树的层序遍历 II
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * @create zhangzhi
     * @date 2022/4/22
     * @time 21:28
     * @description 按层序遍历完之后反转 ans
     */
    public static List<List<Integer>> solution(TreeNode root){
        if (root == null) return new ArrayList<>();
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
}
