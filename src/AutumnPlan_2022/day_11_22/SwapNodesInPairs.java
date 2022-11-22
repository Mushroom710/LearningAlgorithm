package AutumnPlan_2022.day_11_22;

// @date 2022/11/22
// @time 21:28
// @author zhangzhi
// @description LeetCode 24 题 两两交换链表中的节点

public class SwapNodesInPairs {

    /**
     * 对于不好统一处理的结点，一般是头结点，可以设置一个虚拟头结点，用于统一处理！
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next != null && cur.next.next != null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            cur.next.next.next = tmp2;

            cur = cur.next.next;
        }

        return dummyNode.next;
    }
}
