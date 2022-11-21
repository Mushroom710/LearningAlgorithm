package AutumnPlan_2022.day_11_21;

// @date 2022/11/21
// @time 19:59
// @author zhangzhi
// @description LeetCode 203 题 移除链表元素
// 分清楚什么时候删除，什么时候移动。注意边界条件！

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(6);
        removeElements(head,6);
    }
}
