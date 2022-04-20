package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
    一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
    请你返回乘积为正数的最长子数组长度。

    示例 1：
        输入：nums = [1,-2,-3,4]
        输出：4
        解释：数组本身乘积就是正数，值为 24 。

    示例 2：
        输入：nums = [0,1,-2,-3,-4]
        输出：3
        解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
        注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。

    示例 3：
        输入：nums = [-1,-2,-3,0,1]
        输出：2
        解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
*/

import java.util.Arrays;

public class Question_1567 {

    public static void main(String[] args) {
        Question_1567 q = new Question_1567();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(q.getMaxLen(nums));
    }

    public int getMaxLen(int[] nums) {
        // 分为两个数组  一个是到当前数字为正数最大的长度   一个是到当前数字为负数最大的长度
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];

        dpmax[0] = nums[0] > 0 ? 1 : 0;
        dpmin[0] = nums[0] < 0 ? 1 : 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dpmax[i] = dpmax[i - 1] + 1;
                dpmin[i] = dpmin[i - 1] == 0 ? 0 : dpmin[i - 1] + 1;
            } else if (nums[i] < 0) {
                dpmax[i] = dpmin[i - 1] == 0 ? 0 : dpmin[i - 1] + 1;
                dpmin[i] = dpmax[i - 1] + 1;
            } else if (nums[i] == 0) {
                dpmax[i] = dpmin[i] = 0;
            }
        }

        return Arrays.stream(dpmax).max().getAsInt();
    }
}

