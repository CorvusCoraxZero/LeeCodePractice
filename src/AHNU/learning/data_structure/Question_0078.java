package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。

    示例 1：

    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：

    输入：nums = [0]
    输出：[[],[0]]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subsets
*/


import java.util.ArrayList;
import java.util.List;

public class Question_0078 {

    public static void main(String[] args) {
        Question_0078 q = new Question_0078();
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> subsets = q.subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    // 迭代解题 遍历nums 每次递归复制之前结果中的子集  然后加入当前元素
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());  // 将空集加入结果集
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> integers : result) {  // 复制数组 并把当前元素添加到复制的数组中 然后填入新增数据表中
                ArrayList<Integer> clone = new ArrayList<>(integers);
                clone.add(num);
                tmp.add(clone);
            }
            result.addAll(tmp);  // 将新增的数据加入结果
        }
        return result;
    }

    // 回溯解法 这道题还有回溯法的解法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();



        return result;
    }
}
