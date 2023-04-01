package LeetCodeSpringRecruitment_2022.seven_week.day_three;


import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/4/27
 * @TIME 21:08
 * @Created by zhangzhi
 * @description LeetCode 257 题 二叉树的所有路径
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePaths {

    /**
     * @create zhangzhi
     * @date 2022/4/27
     * @time 21:35
     * @description 回溯
     * 归去来兮！
     */
    public static void recursion(TreeNode root,List<Integer> path,List<String> ans){
        path.add(root.val);// 底下有逻辑可以保证不为 null 节点
        if (root.left == null && root.right == null){// 叶子节点的判定 ！ 非常重要
            StringBuilder s = new StringBuilder();
            for (int i = 0;i < path.size() - 1;i++){// 注意生成路径时，有点小技巧
                s.append(path.get(i));
                s.append("->");
            }
            s.append(path.get(path.size() - 1));// 把最后一个拼接上
            ans.add(s.toString());
            return;
        }
        if (root.left != null){// 左子树不为空
            recursion(root.left,path,ans);
            path.remove(path.size() - 1);// 回溯
        }
        if (root.right != null){// 右子树不为空
            recursion(root.right,path,ans);
            path.remove(path.size() - 1);// 回溯
        }
    }


    public static List<String> solution(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recursion(root,path,ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
