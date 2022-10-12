package AutumnPlan_2022.day_10_12;

// @date 2022/10/12
// @time 11:01
// @author zhangzhi
// @description LeetCode 1669 合并两个链表

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeInBetweenLinkedLists {

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node_a = null;
        ListNode node_b = null;
        int idx = 0;
        ListNode cur = list1;
        while (cur != null) {
            if(idx == a - 1){
                node_a = cur;
            }
            if(idx == b + 1){
                node_b = cur;
            }
            cur = cur.next;
            idx++;
        }
        cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        node_a.next = list2;
        cur.next = node_b;
        return list1;
    }

    public static void main(String[] args) {

    }
}
