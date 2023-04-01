package AutumnPlan_2023.March.day_3_17;

// @date 2023/3/17
// @time 21:35
// @author zhangzhi
// @description LeetCode 24. 两两交换链表中的节点

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {

    /**
     * 本以为会很容易就写出代码，没想到还是轻敌了！链表果然非常考验逻辑思维能力，不能大意和想当然！
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        pre.next = cur.next;
        cur.next = cur.next.next;
        pre.next.next = cur;
        while(cur.next != null && cur.next.next != null){
            pre = cur;
            cur = cur.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3 , node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node = new ListNode(1, node1);
        print(swapPairs(node));
    }
}
