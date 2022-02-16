package AHNU.learning.data_structure;

/*
    给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。

    示例 1:
        输入: temperatures = [73,74,75,71,69,72,76,73]
        输出:[1,1,4,2,1,1,0,0]
    示例 2:
        输入: temperatures = [30,40,50,60]
        输出:[1,1,1,0]
    示例 3:
        输入: temperatures = [30,60,90]
        输出: [1,1,0]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/daily-temperatures
*/

import java.util.ArrayDeque;
import java.util.HashMap;

public class Question_0739 {

    public static void main(String[] args) {
        Question_0739 q = new Question_0739();
        int[] str = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = q.dailyTemperatures(str);
        for (int temperature : temperatures) {
            System.out.println(temperature);
        }
    }


    // 使用递减的单调栈 使用递减的单调栈来实现
    public int[] dailyTemperatures(int[] temperatures) {
        // 递减单调栈 填入坐标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 结果数组
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (true) {
                // 如果小于栈顶元素h或者栈顶元素为空就入栈
                if (deque.isEmpty() || temperatures[i] <= temperatures[deque.peek()]) {
                    deque.push(i);
                    break;
                }
                // 如果大于栈顶元素就出栈  因为已经找到左边比他大的了
                if (temperatures[i] > temperatures[deque.peek()]) {
                    result[deque.peek()] = i - deque.peek();
                    deque.pop();
                }
            }
        }
        return result;
    }

    // 一样的思路 内存消耗和时间更快 因为使用的是底层数组
    public int[] dailyTemperaturesPro(int[] temperatures) {
        // 单调递减栈
        final int n = temperatures.length;
        int[] stack = new int[n];
        int p = -1;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            while (p > -1 && temperatures[i] > temperatures[stack[p]]) {
                int index = stack[p--];
                result[index] = i - index;
            }
            stack[++p] = i;
        }
        return result;
    }
}



