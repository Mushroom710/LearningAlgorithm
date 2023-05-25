package AutumnPlan_2023.May.day_5_25;

// @date 2023/5/25
// @time 9:30
// @author zhangzhi
// @description LeetCode 19. 删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = dummy;
        for(int i = 1; i <= n; i++){
            right = right.next;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
