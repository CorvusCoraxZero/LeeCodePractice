package AHNU.learning.data_structure;

/*
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。

    示例 1：
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question_0029 {

    public static void main(String[] args) {
        Question_0029 q = new Question_0029();
        int dividend = -2147483648;
        int divisor = -1;
        // System.out.println(q.fastDup(-7,-2));
        System.out.println(q.divide2(dividend, divisor));
    }

    // 超时了
    public int divide(int dividend, int divisor) {
        int i = 0;
        boolean IsNegative = false;
        // 判断结果是否为负数
        if ((dividend < 0) ^ (divisor < 0)) {
            IsNegative = true;
        }
        // 负数的运算范围大一点 全部转换为负数
        if ((dividend > 0)) {
            dividend *= -1;
        }
        if (divisor > 0) {
            divisor *= -1;
        }
        while (divisor >= dividend) {
            dividend -= divisor;
            i--;
        }
        if (!IsNegative) {
            if (i == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            i *= -1;
        }
        return i;
    }

    // 使用 快速乘法 的方法进行优化
    public int divide2(int dividend, int divisor) {
        int result = 0;
        boolean IsNegative = false;
        // 判断结果是否为负数
        if ((dividend < 0) ^ (divisor < 0)) {
            IsNegative = true;
        }
        // 负数的运算范围大一点 全部转换为负数
        if ((dividend > 0)) {
            dividend *= -1;
        }
        if (divisor > 0) {
            divisor *= -1;
        }

        result = fastDup(dividend,divisor);

        if (!IsNegative) {
            if (result == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result *= -1;
        }
        return result;
    }

    // aim和factor都是负数
    public int fastDup(int aim, int factor) {
        int step, ressult = 0;
        int temp;
        while (aim <= factor){
            step = 0;
            temp = factor;
            // if (aim <= temp) {
            //     step = -1;
            //     temp <<= 1;
            // }else {
            //     break;
            // }
            int minValue = Integer.MIN_VALUE >> 1;
            boolean flag = true;
            while (aim <= temp) {
                if (step == 0){
                    step = -1;
                }else{
                    step <<= 1;
                }
                if (temp < minValue){
                    flag = false;
                    break;
                }
                temp <<= 1;
            }
            if (flag){
                aim -= (temp>>1);
            }else {
                aim -= temp;
            }
            ressult += step;
        }
        return ressult;
    }
}
