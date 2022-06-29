package AHNU.learning.data_structure;

/*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。

    示例 1：
        输入：x = 123
        输出：321

    示例 2：
        输入：x = -123
        输出：-321

    示例 3：
        输入：x = 120
        输出：21

    示例 4：
        输入：x = 0
        输出：0

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/reverse-integer
*/

public class Question_0007 {

    public static void main(String[] args) {
        Question_0007 q = new Question_0007();
        int input = 1463847412;
        System.out.println(q.reverse(input));
    }

    public int reverse(int input) {
        boolean isNegative = false;
        if (input < 0) {
            if (input == Integer.MIN_VALUE){
                return 0;
            }
            isNegative = true;
            input *= -1;
        }
        int result = 0;
        while (input / 10 > 0) {
            result = result * 10 + input % 10;
            input /= 10;
        }
        if (result > Integer.MAX_VALUE / 10) {
            return 0;
        } else if (result == Integer.MAX_VALUE / 10) {
            if (isNegative && Math.abs(Integer.MIN_VALUE % 10) < input) {
                return 0;
            } else if (!isNegative && Integer.MAX_VALUE % 10 < input) {
                return 0;
            }
            result = result * 10 + input % 10;
        } else {
            result = result * 10 + input % 10;
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }
}
