package LeetCodeSpringRecruitment_2022.nine.day_one;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @DATE 2022/5/9
 * @TIME 21:53
 * @Created by zhangzhi
 * @description LeetCode 501 题 二叉搜索树中的众数
 */

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

public class FindModeInBinarySearchTree {

    /**
     * @create zhangzhi
     * @date 2022/5/9
     * @time 22:03
     * @description 遍历树，统计出每一个数出现的频率
     */
    public static void bst(TreeNode root, Map<Integer,Integer> map){
        if (root == null)return;
        map.put(root.val,map.getOrDefault(root.val,0) + 1);
        bst(root.left,map);
        bst(root.right,map);
    }

    public static int[] solution(TreeNode root){
        if (root == null)return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        bst(root,map);
        // 又出现了，Entry，这个可以把 map 的 k-v 结构看成一个整体
        // 这个 sorted 是我很少见到的，多多学习学习
        List<Map.Entry<Integer,Integer>> mapList = map.entrySet().stream()
                .sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size();i++){
            if (mapList.get(i).getValue() == mapList.get(i-1).getValue()){
                list.add(mapList.get(i).getKey());
            }else {
                break;
            }
        }
        // 又是没有见过的转换方式
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static TreeNode pre;
    static List<Integer> list;
    static int count;
    static int maxRate;

    /**
     * @create zhangzhi
     * @date 2022/5/9
     * @time 22:21
     * @description 中序遍历
     * 这个技巧可以好好琢磨琢磨
     * 这里使用了 pre 指针和 cur 指针的技巧。
     * 弄一个指针指向前一个节点，这样每次cur（当前节点）才能和pre（前一个节点）作比较。
     * 而且初始化的时候 pre = NULL，这样当pre为NULL时候，我们就知道这是比较的第一个元素。
     */
    public static void searchBST(TreeNode root){
        if (root == null)return;

        searchBST(root.left); // 左

        // 中
        if (pre == null){
            count = 1;
        }else if (pre.val == root.val){
            count++;
        }else {
            count = 1;
        }
        pre = root;
        if (count == maxRate){
            list.add(root.val);
        }
        // 这里简直就是神来之笔，这样就可以保证新的最大频率总是可以更新到
        // 同时又不需要先找到最大频率，然后再找出所有满足条件的节点
        if (count > maxRate){
            maxRate = count;
            list.clear();// 找到新的最大频率需要把之前找到的清空掉，因为之前的频率已经不是最大频率了
            list.add(root.val);
        }

        searchBST(root.right);// 右
    }

    public static int[] solution_two(TreeNode root){
        pre = null;
        list = new ArrayList<>();
        count = 0;
        maxRate = 0;
        searchBST(root);
        int[] ans = new int[list.size()];
        int idx = 0;
        for (Integer val : list){
            ans[idx++] = val;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
