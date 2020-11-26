package AHNU.learning.data_structure;

/*
    实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须 原地 修改，只允许使用额外常数空间。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/next-permutation
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question_0031 {

    public static void main(String[] args) {
        Question_0031 q = new Question_0031();
        int[] nums = {2, 4, 3, 1};
        q.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

     /*解完题发现其实不需要对后面的数字进行排序 因为交换完后其实是倒序的直接反转就好*/
    // 思路很简单 从数组后面往前找 找到当前遍历过的数字比前一个数字大一点 就交换顺序 并对后面的数字进行排序
    public void nextPermutation(int[] nums) {
        int temp, biger;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            } else if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) { // 从遍历过的数字中寻找比前面的数字正好大一点的
                    if (nums[j] > nums[i - 1]) {
                        temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
    }

}
