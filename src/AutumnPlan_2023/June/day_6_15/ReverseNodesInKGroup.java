package AutumnPlan_2023.June.day_6_15;

// @date 2023/6/15
// @time 11:10
// @author zhangzhi
// @description LeetCode 25. K 个一组翻转链表
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        while(cur != null){
            n += 1;
            cur = cur.next;
        }
        ListNode p0 = dummy;
        ListNode p0nxt = dummy.next;
        while(n >= k){
            n -= k;
            cur = p0.next;
            ListNode pre = null;
            for(int i = 0; i < k; i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            p0.next = pre;
            p0nxt.next = cur;
            p0 = p0nxt;
            p0nxt = p0.next;
        }
        return dummy.next;
    }
}
