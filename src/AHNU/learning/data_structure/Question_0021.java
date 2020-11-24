package AHNU.learning.data_structure;

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Question_0021 {

    public static void main(String[] args) {
        Question_0021 q = new Question_0021();
        Scanner sc = new Scanner(System.in);
        int temp;
        ListNode headf = new ListNode();
        ListNode heads = new ListNode();
        ListNode indexf = headf,indexs = heads,pro = headf;

        while (true){
            temp = sc.nextInt();
            if (temp != -1)
            {
                indexf.val = temp;
                indexf.next = new ListNode();
                pro = indexf;
                indexf = indexf.next;
            }else {
                pro.next = null;
                break;
            }
        }
        pro = heads;
        while (true){
            temp = sc.nextInt();
            if (temp != -1)
            {
                indexs.val = temp;
                indexs.next = new ListNode();
                pro = indexs;
                indexs = indexs.next;
            }else {
                pro.next = null;
                break;
            }
        }
        ListNode index = q.mergeTwoLists(headf,heads);
        while (true){
            System.out.println(index.val);
            if (index.next == null) break;
            index = index.next;
        }
    }

    // 使用栈 遇见相对的括号就弹出 不相对的就压入 结束时如果为空则为真  可能为了省事用了ArrayList 效率慢了点 改成数组下标来做应该效率更高
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode result = new ListNode(),index = result,pro=index;
        while (true){
            if (l1 != null && l2 != null){
                if (l1.val > l2.val){
                    index.val = l2.val;
                    l2 = l2.next;
                }else {
                    index.val = l1.val;
                    l1 = l1.next;
                }
            }
            else if (l1 == null && l2== null){
                pro.next = null;
                return result;
            }else if (l1 == null){
                index.val = l2.val;
                l2 = l2.next;
            }else if (l2 == null){
                index.val = l1.val;
                l1 = l1.next;
            }
            index.next = new ListNode();
            pro = index;
            index = index.next;


        }
    }

}
