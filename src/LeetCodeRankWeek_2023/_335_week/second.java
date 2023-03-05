package LeetCodeRankWeek_2023._335_week;

// @date 2023/3/5
// @time 10:27
// @author zhangzhi
// @description

// 思路：先对树进行层序遍历，计算出每一层的层和，放入优先队列中，
// 优先队列默认是升序排列，所以遍历优先队列就可以找到第 K 大层和

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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

public class second {

    private static void sequenceTraversal(Queue<TreeNode> queue, Queue<Long> qq,TreeNode root){
        TreeNode cur = root;
        queue.add(cur);
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            // 注意添加层和到优先队列的时机
            qq.add(sum);
        }
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Long> qq = new PriorityQueue<Long>();
        sequenceTraversal(queue,qq,root);
        if(qq.size() < k){
            return -1;
        }
        int size = qq.size();
        for (int i = 0; i < size - k; i++){
            qq.poll();
        }
        return qq.peek();
    }

    public static void main(String[] args){
        TreeNode n3 = new TreeNode(3,null,null);
        TreeNode n2 = new TreeNode(2,n3,null);
        TreeNode n1 = new TreeNode(1,n2,null);
        System.out.println(kthLargestLevelSum(n1,1));
    }
}
