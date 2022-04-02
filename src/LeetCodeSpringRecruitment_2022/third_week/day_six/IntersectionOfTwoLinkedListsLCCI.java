package LeetCodeSpringRecruitment_2022.third_week.day_six;

import javax.swing.*;

/**
 * @DATE 2022/4/2
 * @TIME 21:16
 * @Created by zhangzhi
 * @description
 */
public class IntersectionOfTwoLinkedListsLCCI {

    /**
     * @create zhangzhi
     * @date 2022/4/2
     * @time 21:33
     * @description
     * 先计算出lenA和lenB，比较哪个大，就让其先移动abs(lenA-lenB)步，
     * 使得两个链表在同一起点，然后依次遍历即可，比较 curA == curB。
     */
    public static ListNode solution(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null){
            curA = curA.next;
            lenA++;
        }
        while (curB != null){
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if(lenA > lenB){
            return hasIntersection(curA,curB,lenA - lenB, lenB);
        }else {
            return hasIntersection(curB,curA,lenB - lenA, lenA);
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/4/2
     * @time 21:40
     * @description 提取出共有部分
     */
    private static ListNode hasIntersection(ListNode maxHead,ListNode minHead,int diff,int minlen){
        while (diff-- >0){
            maxHead = maxHead.next;
        }
        while (minlen -- > 0){
            if (maxHead == minHead){
                return maxHead;
            }else {
                maxHead = maxHead.next;
                minHead = minHead.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
