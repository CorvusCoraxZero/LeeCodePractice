package AHNU.learning.data_structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
*/
public class Question_0001 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        Question_0001 q = new Question_0001();
        int[] result = q.twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // 暴力解法 会出现超时
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i <= nums.length-1; i++){
            for (int j = i+1; j <= nums.length-1; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
                else continue;

            }
        }
        return result;
    }

    // hash解法  会导致同样的一个数使用两边的情况
   /* public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                int[] result = new int[] {i,map.get(target - nums[i])};
                Arrays.sort(result);
                return result;
            }
        }
        return null;
    }*/

    // hash解法——改进 将循环中本次的数值 先对map进行查找 再加入map 避免上述问题
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = new int[]{i, map.get(target - nums[i])};
                Arrays.sort(result);
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
