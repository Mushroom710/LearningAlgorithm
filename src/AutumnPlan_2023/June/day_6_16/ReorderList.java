package AutumnPlan_2023.June.day_6_16;

// @date 2023/6/16
// @time 10:16
// @author zhangzhi
// @description LeetCode 143. 重排链表
public class ReorderList {
    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public void reorderList(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode head2 = reverse(middle);
        while(head2.next != null){
            ListNode nxt = head.next;
            ListNode nxt2 = head2.next;

            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = nxt2;
        }
    }
}
