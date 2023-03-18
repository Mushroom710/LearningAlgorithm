package AutumnPlan_2023.day_3_18;

// @date 2023/3/18
// @time 21:36
// @author zhangzhi
// @description LeetCode 删除链表的倒数第 N 个结点

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(n-- >= 0){
            cur = cur.next;
        }
        while(cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
