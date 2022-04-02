package LeetCodeSpringRecruitment_2022.third_week.day_six;

/**
 * @DATE 2022/4/2
 * @TIME 21:00
 * @Created by zhangzhi
 * @description LeetCode 19 题 删除链表的倒数第 N 个结点
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {

    /**
     * @create zhangzhi
     * @date 2022/4/2
     * @time 21:06
     * @description 双指针法。使用虚拟头节点 dumy ，
     * fast和 slow 初始化指向dumy，fast先走n+1步，
     * 这样就可以保证slow指向要删除节点的上一个节点。
     */
    public static ListNode solution(ListNode head, int n){
        ListNode dumy = new ListNode();
        dumy.next = head; // 虚拟头节点
        ListNode fast = dumy;
        ListNode slow = dumy;

        // fast 先走 n + 1 步
        for(int i = 0; i < n + 1; i++){
            fast = fast.next;
        }
        // 处理 fast 先走 n + 1 不后为 null 的情况
        // 这就情况就说明 slow 已经指向了待删除节点的前一个节点
        if(fast == null){
            return slow.next.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        return dumy.next;
    }

    public static void main(String[] args) {

    }
}
