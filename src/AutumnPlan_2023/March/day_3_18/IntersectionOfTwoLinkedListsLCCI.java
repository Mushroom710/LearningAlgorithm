package AutumnPlan_2023.March.day_3_18;

// @date 2023/3/18
// @time 21:50
// @author zhangzhi
// @description LeetCode 面试题 02.07. 链表相交
// 这道题和 移出倒数第 N 个节点有相同的解法，都是有一个先走 diff 个节点
// 当然，得先计算出链表的节点长度，然后再移动

public class IntersectionOfTwoLinkedListsLCCI {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(true){
            if(curA == null && curB == null){
                break;
            }
            if(curA != null){
                lenA++;
                curA = curA.next;
            }
            if(curB != null){
                lenB++;
                curB = curB.next;
            }
        }
        if(lenA > lenB){
            curA = headA;
            curB = headB;
        }else {
            curA = headB;
            curB = headA;
        }
        int diff = Math.abs(lenA - lenB);
        for(int i = 0; i < diff; i++){
            curA = curA.next;
        }
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
