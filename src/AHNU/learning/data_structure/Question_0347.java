package AHNU.learning.data_structure;

/*
   给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

    示例 1:
        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]

    示例 2:
        输入: nums = [1], k = 1
        输出: [1]

    进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/top-k-frequent-elements
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question_0347 {

    public static void main(String[] args) {
        Question_0347 q = new Question_0347();
        int[] ints = new int[]{1, 1, 1, 2, 2, 3};
        int[] frequent = q.topKFrequent(ints, 2);
        Arrays.stream(frequent).forEach(x -> System.out.println(x));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey((Integer) num)) {
                map.put(num, 0);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE, maxKey = -1;
            for (Integer key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            list.add(maxKey);
            map.remove(maxKey);
            max = Integer.MIN_VALUE;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}