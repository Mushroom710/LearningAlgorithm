package LeetCodeSpringRecruitment_2022.third_week.day_four;


/**
 * @DATE 2022/3/31
 * @TIME 14:05
 * @Created by zhangzhi
 * @description LeetCode 707 题 设计链表
 * 链表有两种操作方式:
 * 1.直接使用原来的链表进行操作
 * 2.设置一个虚拟头节点来操作
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    // 用于存储链表节点个数
    int size;
    // 虚拟头节点
    ListNode head;

    // 初始化
    MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取第index个节点的数值
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode cur = head;
        // 包含一个虚拟头节点，所以查找第 index+1 个节点，这就说明了为什么index>=size是不可以的
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        // index 小于 0 就在链表头部插入
        if (index < 0) {
            index = 0;
        }
        ListNode pre = head;
        // 找到要插入节点的前驱
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode pre = head;
        // 找到删除结点的前驱
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

public class DesignLinkedList {

    public static void main(String[] args) {

    }
}
