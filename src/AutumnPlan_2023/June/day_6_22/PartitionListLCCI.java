package AutumnPlan_2023.June.day_6_22;

// @date 2023/6/22
// @time 21:42
// @author zhangzhi
// @description LeetCode 面试题 02.04. 分割链表
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class PartitionListLCCI {
    public ListNode partition(ListNode head, int x) {
        ListNode dl = new ListNode(-1);
        ListNode dgt = new ListNode(-1);
        ListNode cur = head;
        ListNode l = dl;
        ListNode gt = dgt;
        while(cur != null){
            if(cur.val >= x){
                gt.next = new ListNode(cur.val);
                gt = gt.next;
            }else{
                l.next = new ListNode(cur.val);
                l = l.next;
            }
            cur = cur.next;
        }
        l.next = dgt.next;
        return dl.next;
    }
}
