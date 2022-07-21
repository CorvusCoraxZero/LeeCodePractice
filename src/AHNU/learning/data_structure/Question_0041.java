package AHNU.learning.data_structure;

/*
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
    
    示例 1：
        输入：nums = [1,2,0]
        输出：3

    示例 2：
        输入：nums = [3,4,-1,1]
        输出：2

    示例 3：
        输入：nums = [7,8,9,11,12]
        输出：1

    提示：
        1 <= nums.length <= 5 * 105
        -231 <= nums[i] <= 231 - 1
    
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/first-missing-positive
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Question_0041 {

    public static void main(String[] args) {
        Question_0041 q3 = new Question_0041();
        int[] input = new int[]{1,1};
        System.out.println(q3.firstMissingPositive2(input));
    }

    // Hash解法
    public int firstMissingPositive(int[] nums) {
        // 获取数组长度将数组最大值设为hash的最大范围 缺失的值肯定在1-max+1之间
        int max = nums.length + 1;
        // 首先排除负数和0的干扰
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = max + 5;
            }
        }

        // 将小于nums.length的元素的指定位置hash位置的元素置为负数 表示该位置上有元素
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 输出遇到的第一个正数的位置+1既是正确答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return max;
    }

    // 使用Hash排序的方式解题
    public int firstMissingPositive2(int[] nums) {
        // 首先删除结果集之外的元素 既大于nums.length的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length) {
                nums[i] = -1;
            }
        }
        // 对元素的位置进行调换
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            // 循环 置换元素 直到当前坐标位置的元素正确
            while ( nums[index] > 0 && nums[index] != index + 1) {
                // 排除出现相同元素 其中一个元素已经在正确位置导致的死循环情况
                if (nums[nums[index] -1] == nums[index]){
                    nums[index] = -1;
                    continue;
                }
                int tmp = nums[index];
                nums[index] =  nums[tmp -1];
                nums[tmp -1] = tmp;
            }
        }
        // 遍历数组第一个位负数的位置既是正确答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
