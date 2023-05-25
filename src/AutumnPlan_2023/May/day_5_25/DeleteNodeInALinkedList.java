package AutumnPlan_2023.May.day_5_25;

// @date 2023/5/25
// @time 9:30
// @author zhangzhi
// @description LeetCode 237. 删除链表中的节点

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
