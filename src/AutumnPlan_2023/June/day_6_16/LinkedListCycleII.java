package AutumnPlan_2023.June.day_6_16;

// @date 2023/6/16
// @time 10:15
// @author zhangzhi
// @description LeetCode 142. 环形链表 II
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode idx1 = head;
                ListNode idx2 = slow;
                while(idx1 != idx2){
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
