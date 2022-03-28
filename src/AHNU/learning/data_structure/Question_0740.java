package AHNU.learning.data_structure;

/*
    给你一个整数数组nums，你可以对它进行一些操作。
    每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
    开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

    示例 1：
        输入：nums = [3,4,2]
        输出：6
        解释：
        删除 4 获得 4 个点数，因此 3 也被删除。
        之后，删除 2 获得 2 个点数。总共获得 6 个点数。
    示例2：
        输入：nums = [2,2,3,3,3,4]
        输出：9
        解释：
            删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
            之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
            总共获得 9 个点数。

    提示：
        1 <= nums.length <= 2 * 104
        1 <= nums[i] <= 104

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/delete-and-earn
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question_0740 {

    public static void main(String[] args) {
        Question_0740 q = new Question_0740();
        int[] ints = {3,4,2};
        System.out.println(q.deleteAndEarn(ints));
    }

    public int deleteAndEarn(int[] nums) {
        // 转换为便于统计数量的map
        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(a -> a.intValue())));
        Integer max = map.keySet().stream().max(Comparator.comparingInt(value -> value)).get();
        int[] dp = new int[max+1];
        dp[0] = map.containsKey(0) ? map.get(0) : 0;
        dp[1] = map.containsKey(1) ? map.get(1) : 0;
        for (int i = 2; i < dp.length; i++) {
            int tmp = map.containsKey(i) ? map.get(i) : 0;
            dp[i] = Math.max(dp[i-1],dp[i-2]+ tmp);
        }
        return dp[max];
    }

}



