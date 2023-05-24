package AutumnPlan_2023.May.day_5_24;

// @date 2023/5/24
// @time 10:49
// @author zhangzhi
// @description LeetCode 141. 环形链表

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
