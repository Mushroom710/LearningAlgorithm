package LeetCodeRankWeek.week;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class second {

    public static ListNode solution(ListNode head){
        ListNode list = new ListNode();
        ListNode cur = list;
        ListNode slow = head;
        ListNode quick = head.next;
        int sum = 0;
        while(quick != null){
            while (quick.val != 0){
                quick = quick.next;
            }
            slow = slow.next;
            while (slow.val != 0){
                sum += slow.val;
                slow = slow.next;
            }
            cur.next = new ListNode(sum);
            sum = 0;
            cur = cur.next;
            quick = quick.next;
        }
        return list.next;
    }

    public static void main(String[] args) {

    }
}
