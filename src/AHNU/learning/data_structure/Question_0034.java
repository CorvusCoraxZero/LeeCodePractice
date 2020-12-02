package AHNU.learning.data_structure;

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
*/

public class Question_0034 {

    public static void main(String[] args) {
        Question_0034 q = new Question_0034();

        int[] nums = {1,2,2,3,3,4,4,5,5,6};
        for (int i : q.searchRange(nums, 6)) {
            System.out.println(i);
        }

    }

    // 使用了分治法的思想 代码写在了工具类里面
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) return new int[]{-1,-1};
        result[0] = Util.leftBoundBinarySearch(nums, target, 0, nums.length - 1);
        result[1] = result[0] == -1 ? -1 : Util.rightBoundBinarySearch(nums, target, 0, nums.length - 1);
        return result;
    }
}
