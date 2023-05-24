package AutumnPlan_2023.May.day_5_24;

// @date 2023/5/24
// @time 10:50
// @author zhangzhi
// @description LeetCode 143. 重排链表
public class ReorderList {
    public ListNode middleNode(ListNode head) {
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
        ListNode mid = middleNode(head);
        ListNode h2 = reverse(mid);
        ListNode h1 = head;
        while(h2.next != null){
            ListNode nxt1 = h1.next;
            ListNode nxt2 = h2.next;
            h1.next = h2;
            h2.next = nxt1;
            h1 = nxt1;
            h2 = nxt2;
        }
    }
}
