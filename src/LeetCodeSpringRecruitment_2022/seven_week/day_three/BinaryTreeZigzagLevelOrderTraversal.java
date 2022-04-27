package LeetCodeSpringRecruitment_2022.seven_week.day_three;

import java.util.*;

/**
 * @DATE 2022/4/27
 * @TIME 21:58
 * @Created by zhangzhi
 * @description LeetCode 103 题 二叉树的锯齿形层序遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * @create zhangzhi
     * @date 2022/4/27
     * @time 22:16
     * @description 使用双端队列。把顺序理清就很简单了。只是要注意方向怎么切换！
     * 一开始没想到一个很好的方法来控制出队方向
     * 后来灵机一动，用奇偶来控制
     */
    public static List<List<Integer>> solution(TreeNode root){
        if (root == null)return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.add(root);
        int flag = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size;i++){
                if (flag % 2 == 0) {// 偶数方向 从左到右
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) deque.addLast(node.left);// 加到队尾
                    if (node.right != null) deque.addLast(node.right);
                }else {// 奇数方向 从右到左
                    TreeNode node = deque.pollLast();
                    list.add(node.val);// 注意左右孩子的入队顺序和入队位置，先右孩子，在左孩子，这样在下一轮遍历就很轻松
                    if (node.right != null)deque.addFirst(node.right);// 加到队首
                    if (node.left != null)deque.addFirst(node.left);
                }
            }
            ans.add(list);
            flag++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
