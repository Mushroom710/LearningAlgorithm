package LeetCode;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 * @description 两数之和。链表题
 * 变量名真的难想。
 * 第一次提交因为用错了变量名出错。。。。
 * 所以，写的时候就要想好需要用的变量，明确每一个变量的作用。
 * 别边写边定义新的变量！！！
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class addTwoNumbers {

    public static ListNode solution(ListNode l1,ListNode l2){
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode list = new ListNode();
        ListNode cur = list;
        int sum; //用于保存 两个结点相加的和
        int a = 0;//如果 sum>9，那么a就改为1.表示进位
        while(head1 != null || head2 != null){
            if(head1 != null && head2 != null){
                sum = head1.val + head2.val + a;
                head1 = head1.next;
                head2 = head2.next;
                a = 0;
            }else if(head1 != null){
                sum = head1.val + a;
                //说明head1.val+a没有大于十，head1之后的结点就不用再加了，直接连到cur.next
                if(sum == head1.val){
                    cur.next = head1;
                    return list.next;
                }
                head1 = head1.next;
                a = 0;
            }else{
                sum = head2.val + a;
                //理由同上
                if(sum == head2.val){
                    cur.next = head2;
                    return list.next;
                }
                head2 = head2.next;
                a = 0;
            }
            if(sum > 9){
                cur.next = new ListNode(sum%10);
                a = 1;
            }else{
                cur.next = new ListNode(sum);
            }
            cur = cur.next;
        }
        if(a > 0){
            cur.next = new ListNode(a);
        }
        return list.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(0);
        n1.next = n2;
        ListNode list = solution(n3,n1);
        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}
