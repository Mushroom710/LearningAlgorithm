package AutumnPlan_2022.day_11_23;

// @date 2022/11/23
// @time 21:31
// @author zhangzhi
// @description LeetCode 19 题 删除链表的倒数第 N 个结点

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {

    /**
     * 快慢指针法。使用虚拟头结点统一操作。先让快指针先走 n+1 步，这样就可以让慢指针停在待删除结点的前一个结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode low = dummyNode;
        ListNode quick = dummyNode;
        for(int i = 0;i <= n; i++){
            quick = quick.next;
        }
        while(quick != null){
            low = low.next;
            quick = quick.next;
        }
        low.next = low.next.next;
        return dummyNode.next;
    }
}
