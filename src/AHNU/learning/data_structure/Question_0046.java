package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   给定一个 没有重复 数字的序列，返回其所有可能的全排列。

    输入: [1,2,3]
    输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/permutations
*/

public class Question_0046 {

    public static void main(String[] args) {
        Question_0046 q = new Question_0046();

        int[] height = {1,2,3,4};
        q.permute(height);
    }

    // 采用探索(深度优先搜索)+回溯的思想 递归实现
    public List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];  // 定义一个数组 记录每个元素的使用状态
        Arrays.fill(flag,-1);
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 1){
            return list;
        }

        permuteRecursion(nums,flag,0,list);
        return list;
    }

    public void permuteRecursion(int[] nums, int[] flag, int layer,List<List<Integer>> list) {
        if (layer == nums.length){
            // 到底了 根据falg 生成一个List装入lsit中
            Integer[] result = new Integer[nums.length];
            for (int i = 0; i <flag.length; i++) {
                result[flag[i]] = nums[i];
            }
            list.add(Arrays.asList(result));
            for (Integer integer : result) {
                System.out.print(integer);
            }
            System.out.println("");
            return;
        }
        // 如果不为最后一个 则使用没使用过的元素往下一层找
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == -1){
                flag[i] = layer;
                permuteRecursion(nums,flag,layer+1,list);
                flag[i] = -1;
            }
        }
    }
}
