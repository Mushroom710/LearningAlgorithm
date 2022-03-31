package LeetCodeSpringRecruitment_2022.third_week.day_four;

/**
 * @DATE 2022/3/31
 * @TIME 14:41
 * @Created by zhangzhi
 * @description LeetCode 206 题 反转链表
 * 一道曾经让我想不明白的一道题
 */
public class ReverseLinkedList {

    /**
     * @create zhangzhi
     * @date 2022/3/31
     * @time 14:55
     * @description 迭代解法。曾经一直想不明白。迷迷糊糊的，现在看来竟是如此简单！！
     */
    public static ListNode solution(ListNode head){
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/31
     * @time 15:05
     * @description 递归解法。这个需要结合递归栈来理解
     */
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
