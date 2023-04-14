package AutumnPlan_2023.April.day_4_14;

// @date 2023/4/14
// @time 16:32
// @author zhangzhi
// @description LeetCode 25. K 个一组翻转链表

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        // 计算链表节点个数
        while(cur != null){
            cur = cur.next;
            n += 1;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        // p0 标志节点
        ListNode p0 = dummy;
        // 反转节点
        cur = p0.next;
        // 标志节点
        ListNode p0Next = p0.next;
        // 前一个节点
        ListNode pre = null;
        while(n >= k){
            n -= k;
            // 正常的反转链表
            for(int i = 0; i < k; i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 修改标志节点的指针，进行下一轮反转链表
            p0.next = pre;
            p0Next.next = cur;
            p0 = p0Next;
            p0Next = p0.next;
            // pre 要重新置为 null
            pre = null;
        }
        return dummy.next;
    }
}
