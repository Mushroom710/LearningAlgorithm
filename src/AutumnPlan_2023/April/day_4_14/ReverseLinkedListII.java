package AutumnPlan_2023.April.day_4_14;

// @date 2023/4/14
// @time 16:33
// @author zhangzhi
// @description LeetCode 92. 反转链表 II

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p0 = dummy;
        // 找到待反转的前一个节点
        for(int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }
        // 保存下一个节点的指针
        ListNode pNext = p0.next;
        // 正常的反转链表
        ListNode cur = p0.next;
        ListNode pre = null;
        for(int i = 0; i < right - left + 1; i++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 修改指针指向
        p0.next = pre;
        pNext.next = cur;

        return dummy.next;
    }
}
