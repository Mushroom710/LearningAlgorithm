package AutumnPlan_2023.June.day_6_15;

// @date 2023/6/15
// @time 11:11
// @author zhangzhi
// @description LeetCode 24. 两两交换链表中的节点
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        // 保证至少有两个节点
        while(cur.next != null && cur.next.next != null){
            ListNode t1 = cur.next;
            ListNode t2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = t1;
            t1.next = t2;

            cur = t1;
        }
        return dummy.next;
    }
}
