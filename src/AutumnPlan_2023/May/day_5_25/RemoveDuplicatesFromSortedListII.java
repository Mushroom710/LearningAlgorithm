package AutumnPlan_2023.May.day_5_25;

// @date 2023/5/25
// @time 9:32
// @author zhangzhi
// @description LeetCode 82. 删除排序链表中的重复元素 II

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                while(cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
