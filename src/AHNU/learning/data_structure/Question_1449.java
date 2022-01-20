package AHNU.learning.data_structure;

/*
    给你一个整数数组cost和一个整数target。请你返回满足如下规则可以得到的最大整数：
    给当前结果添加一个数位（i + 1）的成本为cost[i]（cost数组下标从 0 开始）。
    总成本必须恰好等于target。
    添加的数位中没有数字 0 。
    由于答案可能会很大，请你以字符串形式返回。
    如果按照上述要求无法得到任何整数，请你返回 "0" 。

    示例 1：
        输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
        输出："7772"
        解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
         数字     成本
          1  ->   4
          2  ->   3
          3  ->   2
          4  ->   5
          5  ->   6
          6  ->   7
          7  ->   2
          8  ->   5
          9  ->   5

    示例 2：
        输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
        输出："85"
        解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。

    示例 3：
        输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
        输出："0"
        解释：总成本是 target 的条件下，无法生成任何整数。

    示例 4：
        输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
        输出："32211"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target
*/

import java.util.Arrays;
import java.util.HashMap;

public class Question_1449 {

    public static void main(String[] args) {
        Question_1449 q = new Question_1449();
        int[] nums = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
        System.out.println(q.largestNumber(nums, 9));
    }

    // 这是一个完全背包问题 所以可一套用一个完全背包问题的状态转移方程
    // dp[i][j]表示前i个元素, 恰好构成成本为j时, 构成的最大的整数(整数用字符串表示, 无效状态用'#'表示)
    // dp[i][j] = std::max(dp[i - 1][j], dp[i][j - cost[i]] + value[i])
    // dp[i - 1][j]: 表示第i件物品选0个
    // dp[i][j - cost[i]] + value[i]: 表示第i件物品至少选一个
    public String largestNumber(int[] cost, int target) {
        // 初始化
        String[][] dp = new String[cost.length + 1][target + 1];

        for (int i = 0; i < cost.length + 1; i++) {
            dp[i][0] = "";
        }

        for (int i = 0; i < target; i++) {
            dp[0][i] = "";
        }

        for (int i = 1; i < cost.length + 1; i++) {
            if (cost[i - 1] <= target) {
                dp[i][cost[i - 1]] = i + "";
            }
        }

        // 遍历
        for (int i = 1; i < cost.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j - cost[i - 1] >= 0 && dp[i][j - cost[i - 1]] != null && !dp[i][j - cost[i - 1]].isEmpty()) {
                    dp[i][j] = max(dp[i - 1][j], i + dp[i][j - cost[i - 1]]);
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j]);
                }
            }
        }

        if (dp[cost.length][target] == null || dp[cost.length][target].isEmpty()) {
            return "0";
        }
        return dp[cost.length][target];
    }

    private String max(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) {
            return str2;
        } else if (str2 == null || str2.isEmpty()) {
            return str1;
        }

        if (str1.length() != str2.length()) {
            if (str1.length() > str2.length()) {
                return str1;
            } else {
                return str2;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return str1;
            } else if (str2.charAt(i) > str1.charAt(i)) {
                return str2;
            } else {
                continue;
            }
        }

        return str1;
    }

    // 根据题目要求 优化写法 将空与非法状态做区分 结构更清晰 思路更明确
    public String largestNumber2(int[] cost, int target) {
        String[][] dp = new String[10][target + 1];
        Arrays.fill(dp[0], "#");
        dp[0][0] = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - cost[i - 1] >= 0 && !dp[i][j - cost[i - 1]].equals("#")) {
                    dp[i][j] = strMax(dp[i][j], i + dp[i][j - cost[i - 1]]);
                }
            }
        }
        return dp[9][target].equals("#") ? "0" : dp[9][target];
    }

    private String strMax(String a, String b) {
        if (a.length() > b.length()) {
            return a;
        }
        if (a.length() < b.length()) {
            return b;
        }
        return a.compareTo(b) > 0 ? a : b;
    }

}



