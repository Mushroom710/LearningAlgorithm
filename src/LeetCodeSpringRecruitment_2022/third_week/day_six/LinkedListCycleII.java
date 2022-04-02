package LeetCodeSpringRecruitment_2022.third_week.day_six;

import java.util.HashSet;
import java.util.Set;

/**
 * @DATE 2022/4/2
 * @TIME 21:50
 * @Created by zhangzhi
 * @description LeetCode 142 题 环形链表II
 */
public class LinkedListCycleII {

    /**
     * @create zhangzhi
     * @date 2022/4/2
     * @time 22:00
     * @description
     * 数据结构set的使用。每走过一个节点，就把当前节点添加进set中，
     * 如果set中已经添加过，就会返回false，说明有环，并且是入环的第一个节点。
     */
    public static ListNode solution(ListNode head){
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();

        while (cur != null){
            if(!set.add(cur)){ // 如果节点添加过，说明有环，并且是入环的第一个节点
                return cur;
            }
            cur = cur.next;
        }
        return null; // 走到链表尾部，此时说明链表没有环
    }

    public static void main(String[] args) {

    }
}
