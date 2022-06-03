package LeetCodeRankWeek._295_week_patch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @DATE 2022/6/3
 * @TIME 8:33
 * @Created by zhangzhi
 * @description 单调栈和线段树简直是必背技能！！！
 */

class Node{
    int val;
    Node next;
    Node(){}
    Node(int val){
        this.val = val;
    }
}

public class three {

    public static boolean isUp(Node head){
        Node cur = head.next;
        while (cur != null && cur.next != null){
            if (cur.val > cur.next.val)return false;
            cur = cur.next;
        }
        return true;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/3
     * @time 10:12
     * @description 链表模拟 --- 经典超时 -- 卡 84 号用例
     */
    public static int totalSteps(int[] nums) {
        Node head = new Node();
        Node cur = head;
        for (int i = 0;i < nums.length;i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        int count = 0;
        Node pre = head.next;
        cur = head.next.next;
        Node p_cur = pre;
        while (!isUp(head)){
            while (cur != null) {
                if (pre.val > cur.val) {
                    while (cur != null && p_cur.val > cur.val) {
                        if (cur.next != null && p_cur.next.val <= cur.next.val){
                            cur = cur.next;
                            break;
                        }
                        cur = cur.next;
                        p_cur = p_cur.next;
                    }
                    if (cur == null){
                        pre.next = null;
                    }else {
                        pre.next = cur;
                        pre = cur;
                        cur = cur.next;
                        p_cur = pre;
                    }
                } else {
                    cur = cur.next;
                    pre = pre.next;
                    p_cur = pre;
                }
            }
            count++;
            pre = head.next;
            p_cur = pre;
            cur = head.next.next;
        }
        return count;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/3
     * @time 10:18
     * @description 单调栈
     */
    public static int solution(int[] nums){
        int ans = 0;
        Deque<int[]> st = new LinkedList<>();
        for (int num : nums){
            int maxT = 0;
            while (!st.isEmpty() && st.peek()[0] <= num){
                maxT = Math.max(maxT,st.pop()[1]);
            }
            maxT = st.isEmpty() ? 0 : maxT + 1;
            ans = Math.max(maxT,ans);
            st.push(new int[]{num,maxT});
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,14,4,14,13,2,6,13};
        System.out.println(totalSteps(nums));
        System.out.println(solution(nums));
    }
}
