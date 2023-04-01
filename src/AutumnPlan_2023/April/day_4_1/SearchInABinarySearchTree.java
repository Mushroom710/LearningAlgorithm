package AutumnPlan_2023.April.day_4_1;

// @date 2023/4/1
// @time 22:18
// @author zhangzhi
// @description LeetCode 700. 二叉搜索树中的搜索

public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ans = root;
        while(ans != null && ans.val != val){
            if(ans.val < val){
                ans = ans.right;
            }else{
                ans = ans.left;
            }
        }
        return ans;
    }
}
