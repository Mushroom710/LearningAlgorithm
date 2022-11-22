package AutumnPlan_2022.day_11_22;

// @date 2022/11/22
// @time 20:54
// @author zhangzhi
// @description LeetCode 206 题 反转链表

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode quick = head;
        ListNode low = null;
        while(cur != null){
            cur = cur.next;
            quick.next = low;
            low = quick;
            quick = cur;
        }
        return low;
    }

    /**
     * 递归法
     * @param pre
     * @param cur
     * @return
     */
    public ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        return reverse(pre, tmp);
    }
}
