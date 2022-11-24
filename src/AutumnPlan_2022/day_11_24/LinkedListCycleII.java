package AutumnPlan_2022.day_11_24;

// @date 2022/11/24
// @time 21:16
// @author zhangzhi
// @description

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {

    /**
     * 标记法。使用set记录走过的结点，当再次走过时，说明有环，此时这个结点是入环的第一个结点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while(cur != null){
            // 添加过，返回 false ，没有添加过，返回 true
            if(!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 看 卡哥 的推导过程来辅助理解
     * 文章：https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
     * 视频：https://www.bilibili.com/video/BV1if4y1d7ob/?vd_source=28a04727b7e40d415a3d6477f4c91312
     * @param head
     * @return
     */
    public ListNode detectCycle_1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode index1 = head;
                ListNode index2 = fast;
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
