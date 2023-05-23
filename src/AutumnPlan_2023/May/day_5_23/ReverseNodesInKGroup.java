package AutumnPlan_2023.May.day_5_23;

// @date 2023/5/23
// @time 9:56
// @author zhangzhi
// @description
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n += 1;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode pnext = p0.next;
        cur = p0.next;
        while(n >= k){
            n -= k;
            for(int i = 0; i < k; i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            p0.next.next = cur;
            p0.next = pre;
            p0 = pnext;
            pnext = p0.next;
        }
        return dummy.next;
    }
}
