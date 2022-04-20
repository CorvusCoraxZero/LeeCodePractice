package AHNU.learning.data_structure;

/*
    给你一个下标从 1 开始的整数数组numbers ，该数组已按非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
    如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
    以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
    你可以假设每个输入 只对应唯一的答案 ，而且你不可以重复使用相同的元素。
    你所设计的解决方案必须只使用常量级的额外空间。

    示例 1：
        输入：numbers = [2,7,11,15], target = 9
        输出：[1,2]
        解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

    示例 2：
        输入：numbers = [2,3,4], target = 6
        输出：[1,3]
        解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。

    示例 3：
        输入：numbers = [-1,0], target = -1
        输出：[1,2]
        解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
*/

import java.util.HashMap;

public class Question_0167 {

    public static void main(String[] args) {
        Question_0167 q = new Question_0167();
        int[] nums = new int[]{2, 3, 4};
        int target = 6;
        for (int s : q.twoSum(nums, target)) {
            System.out.print(s + " \n");
        }
    }

    // 非常数级额外空间方案
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = i + 1;
                result[1] = map.get(target - numbers[i]);
                return result;
            }
        }
        result[0] = result[1] = -1;
        return result;
    }

    // 常数级额外空间方案 有序数值 双指针头尾找
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            else if (numbers[left] + numbers[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}

