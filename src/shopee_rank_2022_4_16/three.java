package shopee_rank_2022_4_16;

import java.util.*;

/**
 * @DATE 2022/4/16
 * @TIME 15:42
 * @Created by zhangzhi
 * @description
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class three {

    static ArrayList<Integer> list;

    public static void BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//根结点入队
        while (!queue.isEmpty()){
            int size = queue.size();//当前队列的大小得记录下来，不然在for循环里会不断的更新
            for(int i = 0;i<size;i++){//遍历队列中的元素。把孩子结点入队
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static int solution(TreeNode root, int[][] ops){
        list = new ArrayList<>();
        BFS(root);
        System.out.println(list);
        int[][] nums = new int[2][list.size()];
        int idx = 0;
        for(int val : list){
            nums[0][idx++] = val;
        }
        System.out.println(Arrays.toString(nums[0]));
        for (int i = 0; i < ops.length; i++){
            if (ops[i][0] == 0){
                for (int j = 0; j < nums.length;j++){
                    if (nums[0][j] >= ops[i][1] && nums[0][j] <= ops[i][2]){
                        nums[1][j] = 0;
                    }
                }
            }else {
                for (int j = 0; j < nums.length;j++){
                    if (nums[0][j] >= ops[i][1] && nums[0][j] <= ops[i][2]){
                        nums[1][j] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length;i++) {
            if (nums[1][i] == 1){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
