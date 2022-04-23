package LeetCodeSpringRecruitment_2022.six_week.day_four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @DATE 2022/4/22
 * @TIME 21:39
 * @Created by zhangzhi
 * @description LeetCode 199 题 二叉树的右视图
 */
public class BinaryTreeRightSideView {

    public static List<Integer> solution(TreeNode root){
        if (root == null)return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 1; i <= size;i++){
                TreeNode node = queue.poll();
                if (i == size){// 当 i == size 时，说明这个时候是最右边的结点，加入结果集
                    ans.add(node.val);
                }
                if (node.left != null)queue.add(node.left);
                if (node.right != null)queue.add(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
