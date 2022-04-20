package LeetCodeSpringRecruitment_2022.six_week.day_three;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @DATE 2022/4/20
 * @TIME 22:02
 * @Created by zhangzhi
 * @description LeetCode 94 题 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> solution(TreeNode root){
        if (root == null)return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){// 指针来访问节点，访问到最底层
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left;// 左
            }else {
                cur = stack.pop();// 从栈里弹出的数据，就是要处理的数据（放进 list 里的数据）
                list.add(cur.val); // 中
                cur = cur.right;// 右
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
