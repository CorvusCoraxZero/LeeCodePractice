package AHNU.learning.data_structure;

/*
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    说明：
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

    输入: [2,2,1]
    输出: 1
*/

import java.util.HashMap;

public class Question_0136 {

    public static void main(String[] args) {
        Question_0136 q = new Question_0136();
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(q.singleNumber(nums));
    }

    // 采用 异或 解题
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
