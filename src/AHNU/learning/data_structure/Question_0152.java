package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

    示例 1:
    输入: [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-product-subarray
*/

public class Question_0152 {

    public static void main(String[] args) {
        Question_0152 q = new Question_0152();
        int[] nums = new int[]{-2};
        System.out.println(q.maxProduct(nums));
    }

    // 使用动态规划的思想 前面最大的正数*当前值 和最小的负数*当前值 与 当前值本身 进行比较 并填入结果集中
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i] = Math.min(dpMax[i-1]*nums[i],Math.min(dpMin[i-1]*nums[i],nums[i]));
        }
        int result = Integer.MIN_VALUE;
        for (int max : dpMax) {
            if (max > result) result = max;
        }
        return result;
    }
}

