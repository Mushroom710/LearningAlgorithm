package AutumnPlan_2023.day_3_15;

// @date 2023/3/15
// @time 21:16
// @author zhangzhi
// @description LeetCode 203. 移除链表元素

class MyLinkedList {

    ListNode list;
    int len;

    public MyLinkedList() {
        this.list = new ListNode();
        this.len = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= len){
            return -1;
        }
        ListNode cur = list;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > len){
            return;
        }
        ListNode cur = list;
        ListNode node = new ListNode(val);
        if(index == len){
            while(cur.next != null){
                cur = cur.next;
            }
        }else{
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
        }
        node.next = cur.next;
        cur.next = node;
        len++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= len){
            return;
        }
        ListNode cur = list;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        len--;
    }

    public void print(){
        ListNode cur = list;
        while (cur.next != null){
            System.out.print(cur.next.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.print();
        myLinkedList.addAtIndex(1,2);
        myLinkedList.print();
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
        myLinkedList.print();
        myLinkedList.deleteAtIndex(2);
        myLinkedList.print();
    }
}
