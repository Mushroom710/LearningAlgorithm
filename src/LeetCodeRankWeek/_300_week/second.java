package LeetCodeRankWeek._300_week;

import java.util.Arrays;

/**
 * @DATE 2022/7/3
 * @TIME 10:58
 * @Created by zhangzhi
 * @description
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class second {

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] nums = new int[m][n];
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx = 0;
        int total = m * n; // 矩阵中元素总数
        ListNode cur = head;
        for(int i = 0; i < total; i++){
            if (cur != null) {
                nums[row][col] = cur.val;
                visited[row][col] = true;
                int nextRow = row + dir[dirIdx][0];
                int nextCol = col + dir[dirIdx][1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    dirIdx = (dirIdx + 1) % 4;
                }
                row = row + dir[dirIdx][0];
                col = col + dir[dirIdx][1];
                cur = cur.next;
            }else {
                nums[row][col] = -1;
                visited[row][col] = true;
                int nextRow = row + dir[dirIdx][0];
                int nextCol = col + dir[dirIdx][1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    dirIdx = (dirIdx + 1) % 4;
                }
                row = row + dir[dirIdx][0];
                col = col + dir[dirIdx][1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(Arrays.deepToString(spiralMatrix(3, 5, head)));
    }
}
