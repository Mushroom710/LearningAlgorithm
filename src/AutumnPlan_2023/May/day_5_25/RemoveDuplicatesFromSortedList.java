package AutumnPlan_2023.May.day_5_25;

// @date 2023/5/25
// @time 9:31
// @author zhangzhi
// @description LeetCode 83. 删除排序链表中的重复元素
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
