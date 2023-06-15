package AutumnPlan_2023.June.day_6_15;

// @date 2023/6/15
// @time 11:10
// @author zhangzhi
// @description LeetCode 92. 反转链表 II
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        for(int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }
        ListNode p0nxt = p0.next;
        ListNode pre = null;
        ListNode cur = p0.next;
        for(int i = 0; i < right - left + 1; i++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next = pre;
        p0nxt.next = cur;
        return dummy.next;
    }
}
