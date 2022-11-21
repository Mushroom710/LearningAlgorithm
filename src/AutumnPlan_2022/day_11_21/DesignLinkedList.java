package AutumnPlan_2022.day_11_21;

// @date 2022/11/21
// @time 20:37
// @author zhangzhi
// @description LeetCode 707 题 设计链表
// 使用带有虚拟头节点的链表

class MyLinkedList{
    int size;

    ListNode head;

    MyLinkedList(){
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if(index >= size || index < 0){
            return -1;
        }
        ListNode cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ListNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}
