package LeetCodeSpringRecruitment_2022.seven_week.day_one;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @DATE 2022/4/25
 * @TIME 22:07
 * @Created by zhangzhi
 * @description LeetCode 559 题 N 叉树的最大深度
 */

// N 叉树定义
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class MaximumDepthOfNAryTree {

    /**
     * @create zhangzhi
     * @date 2022/4/25
     * @time 22:11
     * @description N 叉树遍历
     */
    public static int solution(Node root){
        if (root == null)return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int qsize = queue.size();
            for (int i = 0; i < qsize;i++){
                Node node = queue.poll();
                // 遍历某个节点的所有子节点
                for (int j = 0;j < node.children.size();j++){
                    queue.add(node.children.get(j));
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
