package AutumnPlan_2022.day_11_23;

// @date 2022/11/23
// @time 21:55
// @author zhangzhi
// @description LeetCode 面试题 02.07. 链表相交

public class IntersectionOfTwoLinkedLists {

    /**
     * 自己误解了 O(N) 复杂度了...
     * O(N) 复杂度只要没出现双重for就可以认为是O(N)！
     * 思路：
     * 先分别计算两个链表长度，
     * 然后让长的链表和短的链表末尾对齐，只有在中情况下才会出现相交的情形(根据题目给出的示例得出)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenB > lenA){
            int tmp = lenB;
            lenB = lenA;
            lenA = tmp;
            ListNode temp = curA;
            curA = curB;
            curB = temp;
        }
        int gap = lenA - lenB;
        while(gap-- >= 0){
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
