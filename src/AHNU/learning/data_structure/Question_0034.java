package AHNU.learning.data_structure;

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
*/

import AHNU.learning.data_structure.entity.Util;

public class Question_0034 {

    public static void main(String[] args) {
        Question_0034 q = new Question_0034();

        int[] nums = {5,7,7,8,8,10};
        for (int i : q.searchRange2(nums, 8)) {
            System.out.println(i);
        }

    }

    // 使用了分治法的思想 代码写在了工具类里面
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) return new int[]{-1, -1};
        result[0] = Util.leftBoundBinarySearch(nums, target, 0, nums.length - 1);
        result[1] = result[0] == -1 ? -1 : Util.rightBoundBinarySearch(nums, target, 0, nums.length - 1);
        return result;
    }

    // 二分查找
    public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) return new int[]{-1, -1};
        result[0] = bfLeftSearch(nums,target);
        result[1] = bfRightSearch(nums,target);
        return result;
    }

    // 找出左边界
    public static int bfLeftSearch(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left < right){
            int index = (left + right)/2;
            if (target == nums[index]){
                right = index;
            }
            else if (target > nums[index]){
                left = index + 1;
            }else if (target < nums[index]){
                right = index - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 找出右边界
    public static int bfRightSearch(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left < right){
            int index = (left + right + 1) / 2; // 当两个数相差1时 偏向大的数值 类似天花板除 完成结束条件
            if (nums[index] == target){
                left = index;
            }else if (target > nums[index]){
                left = index + 1;
            }else if (target < nums[index]){
                right = index - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

}
