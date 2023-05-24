package AutumnPlan_2023.May.day_5_24;

// @date 2023/5/24
// @time 10:50
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
                ListNode idx1 = slow;
                ListNode idx2 = head;
                while(idx1 != idx2){
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx2;
            }
        }
        return null;
    }
}
