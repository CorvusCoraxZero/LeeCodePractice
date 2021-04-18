package AHNU.learning.data_structure;

/*
    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

    示例 1：
        输入：nums = [1,3,4,2,2]
        输出：2
    示例 2：
        输入：nums = [3,1,3,4,2]
        输出：3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-the-duplicate-number

    进阶：
        不修改数组 nums 的情况下解决这个问题
        只用常量级 O(1) 的额外空间解决这个问题
        时间复杂度小于 O(n2) 的解决方案

*/

public class Question_0287 {

    public static void main(String[] args) {
        Question_0287 q = new Question_0287();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(q.findDuplicate(nums));

    }

    // 二分查找
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}