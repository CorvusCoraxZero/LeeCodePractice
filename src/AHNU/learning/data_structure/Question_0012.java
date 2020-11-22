package AHNU.learning.data_structure;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum

*/


import java.lang.reflect.Array;
import java.util.*;

public class Question_0012 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
//                     0  1  2  3   4   5  6  7  8
        Question_0012 q = new Question_0012();

        List<List<Integer>> result = q.ThreeSum2(nums);
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

    //采用排序+双指针的方法即可避免了重复的同时保证了时间复杂度
    public List<List<Integer>> ThreeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list; // 如果没有解答 题目要求输出一个空列表 null不行
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // 排序后 下一个数和前一个数不相等 才进入循环
                int a = i + 1, b = nums.length - 1;
                while (a < b) {
                    if (a == i + 1 || b == nums.length - 1 || nums[a] > nums[a - 1] && nums[b] < nums[b + 1]) {
                        if (nums[a] + nums[b] + nums[i] == 0) {
                            list.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[i], nums[a], nums[b]})));
                            a++;
                            b--;
                        } else if (nums[a] + nums[b] + nums[i] > 0) {
                            b--;
                        } else {
                            a++;
                        }
                    } else if (nums[a] <= nums[a - 1]) {
                        a++;
                    } else if (nums[b] >= nums[b + 1]) {
                        b--;
                    }

                }
            }
        }
        return list;
    }
}
