package AutumnPlan_2023.May.day_5_26;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// @date 2023/5/26
// @time 11:11
// @author zhangzhi
// @description LeetCode 257. 二叉树的所有路径
class Packet{
    TreeNode node;
    List<Integer> list;
    Packet(TreeNode node){
        this.node = node;
        this.list = new ArrayList<>();
    }
    Packet(){}
}
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<Packet> stack = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        Packet p = new Packet(root);
        p.list.add(root.val);
        stack.push(p);
        while(!stack.isEmpty()){
            p = stack.pop();
            if(p.node.left == null && p.node.right == null){
                StringBuilder sb = new StringBuilder();
                sb.append(p.list.get(0));
                for(int i = 1; i < p.list.size(); i++){
                    sb.append("->").append(p.list.get(i));
                }
                ans.add(sb.toString());
            }
            if(p.node.right != null){
                Packet right = new Packet(p.node.right);
                right.list.addAll(p.list);
                right.list.add(p.node.right.val);
                stack.push(right);
            }
            if(p.node.left != null){
                Packet left = new Packet(p.node.left);
                left.list.addAll(p.list);
                left.list.add(p.node.left.val);
                stack.push(left);
            }
        }
        return ans;
    }
}
