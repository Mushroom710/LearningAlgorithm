package AutumnPlan_2023.April.day_4_14;

// @date 2023/4/14
// @time 16:34
// @author zhangzhi
// @description LeetCode 206. 反转链表

public class ReverseLinkedList {
    private static ListNode reverse(ListNode cur){
        if(cur == null || cur.next == null){
            return cur;
        }
        ListNode newHead = reverse(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return newHead;
    }

    /**
     * 递归法 一个变量
     */
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    private static ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
        return reverse(pre, cur);
    }
    /**
     * 递归法 两个变量
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }


    /**
     * 迭代法
     */
    public ListNode reverseList3(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
