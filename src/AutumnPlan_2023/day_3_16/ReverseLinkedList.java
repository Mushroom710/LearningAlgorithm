package AutumnPlan_2023.day_3_16;

// @date 2023/3/16
// @time 21:41
// @author zhangzhi
// @description LeetCode 206. 反转链表

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    /**
     * 迭代法
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法
     */
    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = reverseList(node1);
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }

    }
}
