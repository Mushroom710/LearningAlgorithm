package AutumnPlan_2023.April.day_4_14;

// @date 2023/4/14
// @time 16:31
// @author zhangzhi
// @description LeetCode 24. 两两交换链表中的节点

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode cur = p0.next;
        ListNode pre = null;
        while(p0.next != null && p0.next.next != null){
            for(int i = 0; i < 2; i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            p0.next = pre;
            pre.next.next = cur;
            p0 = pre.next;
            pre = null;
        }
        return dummy.next;
    }
}
