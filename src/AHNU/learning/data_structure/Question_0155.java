package AHNU.learning.data_structure;

/*
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/min-stack
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Question_0155 {

    public static void main(String[] args) {
        Question_0155 q = new Question_0155();
        int[] nums = new int[]{-2};
        System.out.println(q.maxProduct(nums));
    }

    // 使用动态规划的思想 前面最大的正数*当前值 和最小的负数*当前值 与 当前值本身 进行比较 并填入结果集中
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i] = Math.min(dpMax[i-1]*nums[i],Math.min(dpMin[i-1]*nums[i],nums[i]));
        }
        int result = Integer.MIN_VALUE;
        for (int max : dpMax) {
            if (max > result) result = max;
        }
        return result;
    }
}

/**
 * 使用一个辅助栈来记录当前位置栈内的最小元素
 */
class MinStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}