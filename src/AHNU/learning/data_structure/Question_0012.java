package AHNU.learning.data_structure;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
*/


import java.lang.reflect.Array;
import java.util.*;

public class Question_0012 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//                     0  1  2  3   4   5  6  7  8
        Question_0012 q = new Question_0012();

        List<List<Integer>> result = q.ThreeSum(nums);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.printf("%3d", integer);
            }
            System.out.println();
        }

    }

    //hashmap + 双循环 但是判重困难 判重部分暂无头绪
    public List<List<Integer>> ThreeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        int target;
        for (int x = 0; x < nums.length; x++) {
            target = nums[x];
            for (int i = 0; i < nums.length; i++) {
                if (i == x) continue;
                if (map.containsKey(-(nums[i] + target))) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(map.get(-(nums[i] + target)));
                    result.add(x);
                    list.add(result);
                }
                map.put(nums[i], i);
            }
        }

        return list;
    }
}
