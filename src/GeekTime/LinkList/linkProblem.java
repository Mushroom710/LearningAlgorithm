package GeekTime.LinkList;

/**
 * @DATE 2022/2/24
 * @Created by zhangzhi
 */

class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    public Node() {

    }
}


public class linkProblem {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/24
     * @time 21:13
    * @description 创建链表
     */
    public static Node createLink(int count){
        Node head = new Node();
        Node cur = head;
        for(int i = 1;i<=count;i++){
            Node node = new Node(i,null);
            cur.next = node;
            cur = node;
        }
        return head.next;
    }
    //打印链表
    public static void printLink(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data+"->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    //题目：相邻的两个链表结点互相交换
    //例：1->2->3->4->5
    //   2->1->4->3->5
    public static void adjacentSwap(Node head){
        if(head == null){
            return;
        }
        Node slow = head;
        Node quick = head.next;
        while(quick != null && slow != null){
            //使用位运算的方式交换数值
            slow.data = slow.data ^ quick.data;
            quick.data = slow.data ^ quick.data;
            slow.data = slow.data ^ quick.data;

            /* 考虑好边界条件。
             * 边界条件就两种。一种是quick.next指向空。另一种是quick.next指向最后一个结点。
             * 这两种情况都可以终止循环
            */
            if(quick.next == null || quick.next.next == null){
                break;
            }
            slow = slow.next.next;
            quick = quick.next.next;
        }
    }

    /*题目：判断链表是否有环
    *   1.暴力解法（控制时间在 0.5秒内）
    *   2.标记法  把访问过的结点记录下来，每次访问结点时，同时看看该结点是否已经被访问过
    *   3.快慢指针法 有环的话，快指针一定能追上慢指针；无环，快指针先到达表尾
    * */
    //快慢指针
    public static void hasCycleSolution1(Node head){
        if(head == null){
            System.out.println("没有环");
            return;
        }
        Node slow = head;
        Node quick = head;
        while(slow != null && quick != null){
            if(slow == quick){
                System.out.println("有环");
                return;
            }
            if(quick.next == null || quick.next.next == null){
                System.out.println("没有环");
                return;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
    }

    public static void main(String[] args) {
        Node head = createLink(3);
        head.next.next = head.next;
//        printLink(head);
//        adjacentSwap(head);
//        printLink(head);
        hasCycleSolution1(head);
    }
}
