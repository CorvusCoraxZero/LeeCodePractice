package AHNU.learning.data_structure;

/*
    泰波那契序列Tn定义如下：
        T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
    给你整数n，请返回第 n 个泰波那契数Tn 的值。

    示例 1：
        输入：n = 4
        输出：4
    解释：
        T_3 = 0 + 1 + 1 = 2
        T_4 = 1 + 1 + 2 = 4

    示例 2：
        输入：n = 25
        输出：1389537

    提示：
        0 <= n <= 37
        答案保证是一个 32 位整数，即answer <= 2^31 - 1。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
*/

public class Question_1137 {

    public static void main(String[] args) {
        Question_1137 q = new Question_1137();
        System.out.println(q.tribonacci( 0));
    }

    public int tribonacci(int n) {
        int[] result = new int[Math.max(3,n+1)];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i-3] + result[i-2] + result[i-1];
        }
        return result[n];
    }

}


