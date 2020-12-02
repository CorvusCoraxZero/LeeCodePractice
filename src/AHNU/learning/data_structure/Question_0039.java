package AHNU.learning.data_structure;

/*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。

    说明：
        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。 

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/combination-sum
*/

import java.util.*;

public class Question_0039 {

    public static void main(String[] args) {
        Question_0039 q = new Question_0039();

        int[] candidates = {7,3};


        for (List<Integer> list : q.combinationSum(candidates,17)) {
            for (Integer n : list) {
                System.out.print(n+" ");
            }
            System.out.println("");
        }
    }

    //使用 回溯算法+剪枝解决 问题  (答案和思路正确 速度却只有24.68% 也没用递归 想一想优化的方法 提升速度)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> index = new ArrayList<>(); // index[i] 表示第i层现在遍历到的位置
        List<List<Integer>> resultList = new ArrayList<>(); // index[i] 表示第i层现在遍历到的位置
        ArrayList result;
        int layer = 0; // 表示当前的层数
        int count = 0; // 表示之前层数的数字相加总和
        int temp; // 临时数据

        if (candidates.length == 0){
            return resultList;
        }

        Arrays.sort(candidates);  // 对数组进行排序  为后续的剪枝提供便利

        index.add(0);
        while (true) {
            while (index.get(layer) >= candidates.length){ // 如果当前层遍历完毕继续返回上一层 如果当前层是第一层则结束循环
                index.set(layer, 0); // 当前层搜索坐标清零 返回上一层搜索 上一层搜索坐标+1
                layer--;
                if (layer <= -1) return resultList;
                count -= candidates[index.get(layer)];
                index.set(layer, index.get(layer) + 1);
            }
            // 尝试当前数字  成功（等于target）填入result返回上一层 可继续（小于target）则进入下一层遍历 不可继续or当前层遍历完毕返回上一层
            temp = candidates[index.get(layer)] + count;
            if (temp == target) {  // 成功（等于target）填入result继续当前层搜索
                result = new ArrayList<Integer>();
                for (int i = 0; i <= layer; i++) {
                    result.add(candidates[index.get(i)]);
                }
                resultList.add(result);
                index.set(layer, 0); // 当前层搜索坐标清零 返回上一层搜索 上一层搜索坐标+1
                layer--;
                if (layer <= -1) break;
                count -= candidates[index.get(layer)];
                index.set(layer, index.get(layer) + 1);
            } else if (temp < target) {
                count = temp;
                layer++;
                if (index.size() < layer + 1 && layer != 0) index.add(index.get(layer-1)); // 初始化下一层 下一层的遍历从上一层的数字开始 防止重复的答案
                index.set(layer,index.get(layer-1));
            } else if (temp > target){
                index.set(layer, 0); // 当前层搜索坐标清零 返回上一层搜索 上一层搜索坐标+1
                layer--;
                if (layer <= -1) break;
                count -= candidates[index.get(layer)];
                index.set(layer, index.get(layer) + 1);
            }
        }
        return resultList;
    }
}
