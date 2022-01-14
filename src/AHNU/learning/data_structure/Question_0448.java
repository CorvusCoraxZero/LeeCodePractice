package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/*
    给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果

    示例 1：
        输入：nums = [4,3,2,7,8,2,3,1]
        输出：[5,6]

    示例 2：
        输入：nums = [1,1]
        输出：[2]

    进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
*/

public class Question_0448 {

    public static void main(String[] args) {
        Question_0448 q = new Question_0448();
        int nums[] = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = q.findDisappearedNumbers(nums);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    // 进阶 先剔除不属于范围的元素 然后再hash
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length <= 0) return new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] - 1 != i) {
                int aim = nums[i];
                int tmp;
                nums[i] = 0;
                while (true) {
                    // 看看要替换目标位置 是否为0 或者已经为目标数
                    if (nums[aim - 1] == 0 || nums[aim - 1] == aim) {
                        nums[aim - 1] = aim;
                        break;
                    } else {
                        tmp = nums[aim - 1];
                        nums[aim - 1] = aim;
                        aim = tmp;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    // 简单版
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        if (nums.length <= 0) return new ArrayList<>();
        int[] record = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                record[nums[i] - 1]++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}



