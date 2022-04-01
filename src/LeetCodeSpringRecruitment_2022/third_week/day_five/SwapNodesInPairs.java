package LeetCodeSpringRecruitment_2022.third_week.day_five;


/**
 * @DATE 2022/4/1
 * @TIME 14:00
 * @Created by zhangzhi
 * @description LeetCode 24 题 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesInPairs {

    /**
     * @create zhangzhi
     * @date 2022/4/1
     * @time 14:02
     * @description 模拟题
     * 一定要画图来辅助解题
     * 分析清楚指针的指向
     * 以及一些边界问题的处理
     * 虚拟头节点雀食可以辅助解题，把一些特殊情况一般化
     */
    public static ListNode solution(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            tmp1.next = tmp2;

            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
