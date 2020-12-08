package AHNU.learning.data_structure;

/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:

    输入: [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-subarray
*/

public class Question_0053 {

    public static void main(String[] args) {
        Question_0053 q = new Question_0053();

        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(q.maxSubArray(nums));
    }


    // 滚动数组？ 动态规划？ 就是找到当前位置最大的序列的值
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int count = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            count += num;
            max = Math.max(count,max);
            if (count <= 0){
                count = 0;
            }
        }
        return max;
    }
}
