package AHNU.learning.data_structure;

/*
    该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
    请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
*/

import AHNU.learning.data_structure.entity.Util;

public class Question_0033 {

    public static void main(String[] args) {
        Question_0033 q = new Question_0033();

        int[] nums = {2, 1};
        System.out.println(q.search(nums, 0));

    }

    //尝试使用 递归+二分查找 的思想解题
    public int search(int[] nums, int target) {
        return searchBinary(nums, target, 0, nums.length - 1);
    }

    public int searchBinary(int[] nums, int target, int begin, int end) {
        // 先分成两个部分  一个有序一个无序
        int mid = (begin + end) / 2;
        if (nums[mid] == target) return mid;
        if (begin == end && nums[begin] != target) return -1;
        // 如果在有序的部分里 直接二分查找写出结果 如果在无序的部分里就递归 直到查找到
        if (nums[begin] <= nums[mid]) { // 说明前半部分所谓有序的 如果不加 = 当前面的部分为空的时 会判断前面的部分为无序的 后面的部分为有序的 其实不然
            if (target >= nums[begin] && target < nums[mid]) { // target在有序的部分
                return Util.binarySearch(nums, target, begin, mid - 1);  // 二分查找
            } else {
                return searchBinary(nums, target, mid + 1, end);
            }
        } else {  // 后半部分是有序的
            if (target > nums[mid] && target <= nums[end]) {  // target在有序的部分
                return Util.binarySearch(nums, target, mid + 1, end);  // 二分查找
            } else {
                return searchBinary(nums, target, begin, mid - 1);
            }
        }
    }

}
