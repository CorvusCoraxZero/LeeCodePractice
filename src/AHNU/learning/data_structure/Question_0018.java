package AHNU.learning.data_structure;

/*
    18. 四数之和
    给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
    （若两个四元组元素一一对应，则认为两个四元组重复）：
    0 <= a, b, c, d< n
    a、b、c 和 d 互不相同
    nums[a] + nums[b] + nums[c] + nums[d] == target
    你可以按 任意顺序 返回答案 。
    
    示例 1：
        输入：nums = [1,0,-1,0,-2,2], target = 0
        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    示例 2：
        输入：nums = [2,2,2,2,2], target = 8
        输出：[[2,2,2,2]]
    
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/4sum
*/


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Question_0018 {

    public static void main(String[] args) {
        Question_0018 q = new Question_0018();
        int input = 58;
        System.out.println(q.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 4) {
            return result;
        }
        // 4个指针 两个顺序遍历 两个头尾指针
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int head = j + 1, rear = nums.length - 1;
                while (head < rear) {
                    if (0L + nums[head] + nums[rear] + nums[i] + nums[j] < target) {
                        head++;
                    } else if (0L + nums[head] + nums[rear] + nums[i] + nums[j] > target) {
                        rear--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[head]);
                        list.add(nums[rear]);
                        set.add(list);
                        head++;
                        rear--;
                    }
                }
            }
        }
        result = new ArrayList<>(set);
        return result;
    }
}
