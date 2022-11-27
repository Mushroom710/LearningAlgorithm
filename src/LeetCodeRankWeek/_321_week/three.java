package LeetCodeRankWeek._321_week;

// @date 2022/11/27
// @time 11:30
// @author zhangzhi
// @description 第 321 场周赛 第三题 从链表中移除节点
// 这个题目可以用单调栈来解决，难点就是怎么保存节点。
// 我这里的解决思路是：保存当前节点的前一个节点，
// 写代码的时候需要特别小心，不要被绕进去了

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class three {

    public static ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        deque.addLast(cur);
        cur = cur.next;
        while(cur != null && cur.next != null){
            ListNode node = deque.peekLast();
            if(node == null){
                return dummy.next;
            }
            while(!deque.isEmpty() && node != null && node.next.val < cur.next.val){
                node.next = cur.next;
                cur = node;
                deque.pollLast();
                node = deque.peekLast();
            }
            deque.addLast(cur);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode cur = head;
        int[] nums = new int[]{2,13,3,8};
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        removeNodes(head);
    }
}
