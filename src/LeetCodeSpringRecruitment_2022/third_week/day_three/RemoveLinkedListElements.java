package LeetCodeSpringRecruitment_2022.third_week.day_three;

import java.util.List;

/**
 * @DATE 2022/3/30
 * @TIME 17:18
 * @Created by zhangzhi
 * @description LeetCode 203 题 移除链表元素
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}
}

public class RemoveLinkedListElements {

    /**
     * @create zhangzhi
     * @date 2022/3/30
     * @time 17:20
     * @description 每一个结点都看一眼，是否是满足删除条件
     */
    public static ListNode solution(ListNode head, int val){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){
            if(next.val == val){
                next = next.next;
                cur.next = next;
            }else{
                next = next.next;
                cur = cur.next;
            }
        }
        // 因为前面的遍历是没有判断head的，所以head这个需要单独判断
        if(head.val == val){
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
