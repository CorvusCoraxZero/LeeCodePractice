package AHNU.learning.data_structure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/*
    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

    示例 1：
        输入：nums = [1,5,11,5]
        输出：true
        解释：数组可以分割成 [1, 5, 5] 和 [11] 。

    示例 2：
        输入：nums = [1,2,3,5]
        输出：false
        解释：数组不能分割成两个元素和相等的子集。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
*/

public class Question_0416 {

    public static void main(String[] args) {
        Question_0416 q = new Question_0416();
        int[] nums = new int[]{1,1};
        System.out.println(q.canPartition(nums));
    }

    // 此方法超时了
    // 首先判断数字和是否是偶数  然后判断能否有数字加起来等于和的一半
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if ((total % 2) != 0) {
            return false;
        }
        int half = total / 2;
        // 如果有一个数大于half直接return false;
        for (int num : nums) {
            if (num > half) return false;
            if (num == half) return true;
        }
        // 深度遍历找到有没有数字加起来等与half
        return DFS(nums, half);
    }

    public boolean DFS(int[] nums, int aim) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) continue;
            if (aim - num < 0) continue;
            if (aim - num == 0) return true;
            nums[i] = 0;
            if (DFS(nums, aim - num)) {
                return true;
            }
            nums[i] = num;
        }
        return false;
    }
}
