package AHNU.learning.data_structure;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
*/


import AHNU.learning.data_structure.entity.ListNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_0019 {

    public static void main(String[] args) {
        ListNode head = new ListNode(),index = head,pro = head;
        int temp,n;
        Question_0019 q = new Question_0019();

        Scanner sc = new Scanner(System.in);
        while (true){
            temp = sc.nextInt();
            if (temp != -1)
            {
                index.val = temp;
                index.next = new ListNode();
                pro = index;
                index = index.next;
            }else {
                pro.next = null;
                break;
            }
        }
        n = sc.nextInt();
        index = q.removeNthFromEnd(head,n);
        while (true){
            System.out.println(index.val);
            if (index.next == null) break;
            index = index.next;
        }
    }

    // 循环n次  通过控制 存储目前位置的index数组每次为答案添上一个字符串 其实通过快慢指针更快 空间更少 但是他要求只遍历一次链表
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode index = head;
        while(true){
            list.add(index);
            if (index.next == null) break;
            index = index.next;
        }
        if (list.size() == n) return head.next;
        list.get(list.size() -1 - n).next = list.get(list.size()- n).next;

        return head;
    }


    // 看评论学习的，很有启发性思维的递归的 retrun 计数法
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        return removeNode(head,n)==n?head.next:head; // 这个三元表达式判断的是要删除的是不是头节点
    }
    public int removeNode(ListNode node,int n) {
        if(node.next == null)  return 1;
        int m = removeNode(node.next, n);
        if(m == n)
            if(m == 1) node.next = null;
            else node.next = node.next.next;
        return m+1;
    }

}
