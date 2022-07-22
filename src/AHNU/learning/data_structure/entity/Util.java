package AHNU.learning.data_structure.entity;

import java.util.Scanner;

public class Util {
    // 创建一个新的链表节点
    public static ListNode createNewListNode() {
        Scanner sc = new Scanner(System.in);
        ListNode node = new ListNode(), head = node;
        int input;
        while (true) {
            input = sc.nextInt();
            if (input != -1) {
                node.next = new ListNode(input);
                node = node.next;
            } else break;
        }
        return head.next;
    }

    // 打印整个链表
    public static void printListNode(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    // 二分查找 在一个升序的数组里
    public static int binarySearch(int[] nums, int target, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;  // 据说这是一个防止溢出技巧
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;//找不到返回-1
    }

    // 寻找左边界的二分查找  其更为本质的思想可以理解为寻找比target小的数有几个
    public static int leftBoundBinarySearch(int[] nums, int target, int left, int right) {
        int mid;
        while (left < right) {   // left为要返回的坐标 当left == right时就会弹出
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 寻找左边界的二分查找  其更为本质的思想可以理解为寻找比target小的数有几个
    public static int rightBoundBinarySearch(int[] nums, int target, int left, int right) {
        int mid;
        while (left < right) {   // left为要返回的坐标 当left == right时就会弹出
            mid = left + (right - left + 1) / 2;  // 地板除的结果改为天花板除法
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
