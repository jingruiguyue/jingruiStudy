package src.com.test.study.algorithm.node;

import jdk.jfr.DataAmount;
import lombok.Data;

/**
 * @Classname ListNode
 * @Description 链表
 * @Date 2025/02/19 17:28
 * @Created by Bruce
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode currentNode = head;

        for (int i = 2; i < 8 ; i++) {
            ListNode nextNode = new ListNode(i);
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode = head;
        //打印链表
        while(currentNode != null){
            System.out.println("当前链表的值是："+ currentNode.getVal());
            currentNode = currentNode.getNext();
        }

        ListNode res = thirdChange(head);

        //反转后打印链表
        while(res != null){
            System.out.println("反转后打印链表的值是："+ res.getVal());
            res = res.getNext();
        }
    }

    public static ListNode changeListNode(ListNode head){
        ListNode current  = head, pre = null;

        while(current != null){
            ListNode next  = current.getNext();
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }




    public static ListNode changeLNode(ListNode head){
        ListNode current = head, pre = null;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }
        return pre;
    }

    public static ListNode thirdChange(ListNode head){
        ListNode change = null;
        while(head != null){
            ListNode next = head.next;
            head.next = change;
            change = head;
            head = next;
        }
        return change;
    }









}
