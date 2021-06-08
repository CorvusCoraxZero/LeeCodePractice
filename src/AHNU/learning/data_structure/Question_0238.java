package AHNU.learning.data_structure;

/*
    给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

    示例:
        输入: [1,2,3,4]
        输出: [24,12,8,6]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/product-of-array-except-self
*/

public class Question_0238 {

    public static void main(String[] args) {
        Question_0238 q = new Question_0238();
        TreeNode tree = TreeNode.getTreeLayer();
    }

    /*
    *   因为不能使用除法 所以动态规划解题
    * */
    public int[] productExceptSelf(int[] nums) {
        int[] dp1 = new int[nums.length];  // 从前往后累乘
        dp1[0] = nums[0];
        int[] dp2 = new int[nums.length];  // 从后往前累乘
        dp2[nums.length-1] = nums[nums.length-1];
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            dp1[i] = nums[i]*dp1[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            dp2[i] = nums[i]*dp2[i+1];
        }
        result[0] = dp2[1];
        result[nums.length-1] = dp1[nums.length-2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = dp1[i-1]*dp2[i+1];
        }
        return result;
    }
}