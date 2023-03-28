package AutumnPlan_2023.day_3_28;

// @date 2023/3/28
// @time 22:16
// @author zhangzhi
// @description LeetCode 257. 二叉树的所有路径

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /**
     * 对于路径需要拼接的，如果不好直接拼接，可以先把要拼接的元素存起来，之后再统一拼接
     */
    private void treePath(TreeNode root, List<Integer> nums, List<String> list){
        nums.add(root.val);
        if(root.left == null && root.right == null){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < nums.size() - 1; i++){
                sb.append(nums.get(i)).append("->");
            }
            sb.append(nums.get(nums.size() - 1));
            list.add(sb.toString());
            return;
        }
        if(root.left != null){
            treePath(root.left, nums, list);
            nums.remove(nums.size() - 1);
        }
        if(root.right != null){
            treePath(root.right, nums, list);
            nums.remove(nums.size() - 1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        treePath(root, nums, list);
        return list;
    }
}
