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
