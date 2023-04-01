package AutumnPlan_2023.March.day_3_18;

// @date 2023/3/18
// @time 22:17
// @author zhangzhi
// @description LeetCode 142. 环形链表 II

public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode idx1 = fast;
                ListNode idx2 = head;
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
