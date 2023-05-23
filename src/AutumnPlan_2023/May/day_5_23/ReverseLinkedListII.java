package AutumnPlan_2023.May.day_5_23;

// @date 2023/5/23
// @time 9:55
// @author zhangzhi
// @description LeetCode 92. 反转链表 II
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-501, head);
        ListNode p0 = dummy;
        for(int i = 1; i < left; i++){
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for(int i = 1; i <= right - left + 1; i++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
