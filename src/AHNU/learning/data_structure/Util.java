package AHNU.learning.data_structure;

import java.util.Scanner;

public class Util {
    public static ListNode createNewListNode(){
        Scanner sc = new Scanner(System.in);
        ListNode node = new ListNode(),head = node;
        int input;
        while (true){
            input = sc.nextInt();
            if (input != -1){
                node.next = new ListNode(input);
                node = node.next;
            }else break;
        }
        return head.next;
    }

    public static void printListNode(ListNode list){
        while (list != null){
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.println();
    }
}
