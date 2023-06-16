package AutumnPlan_2023.June.day_6_16;

// @date 2023/6/16
// @time 10:17
// @author zhangzhi
// @description LeetCode 82. 删除排序链表中的重复元素 II
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
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
