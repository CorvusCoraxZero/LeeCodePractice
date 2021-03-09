package AHNU.learning.data_structure;

/*
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    求在该柱状图中，能够勾勒出来的矩形的最大面积。
*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_0084 {

    public static void main(String[] args) {
        Question_0084 q = new Question_0084();
        int[] nums = new int[]{2, 1,0,2};
        System.out.println(q.largestRectangleArea3(nums));
    }

    // 暴力解法： 因为矩形的高一旦确定 矩形的形状也就确定了 所以遍历所有的高
    // 失败 超时了
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;//往两边找 找到比他矮的就停止
            for (int j = i; j < heights.length; j++) {
                if (j == heights.length - 1 && heights[j] >= heights[i]) {
                    right = j;
                } else if (heights[j] < heights[i]) {
                    right = j - 1;
                    break;
                }
            }
            for (int j = i; j >= 0; j--) {
                if (j == 0 && heights[j] >= heights[i]) {
                    left = 0;
                }
                if (heights[j] < heights[i]) {
                    left = j + 1;
                    break;
                }
            }
            if (maxArea < (right - left + 1) * heights[i]) {
                maxArea = (right - left + 1) * heights[i];
            }
        }
        return maxArea;
    }

    // 使用单调栈解法
    public int largestRectangleArea2(int[] heights) {
        List<Integer> monotonicStack = new ArrayList<>();
        int[] left = new int[heights.length]; // 存放离左边小于当前元素最近的元素的右一个元素
        int[] right = new int[heights.length]; // 左边换成右边同理

        // 从左往右遍历获得 存放离左边小于当前元素最近的元素的右一个元素
        for (int i = 0; i < heights.length; i++) {
            while (true) {
                if (monotonicStack.isEmpty()) { // 如果为空入栈
                    monotonicStack.add(i);
                    left[i] = 0;
                    break;
                } else if (heights[monotonicStack.get(monotonicStack.size() - 1)] < heights[i]) {
                    monotonicStack.add(i);
                    left[i] = monotonicStack.get(monotonicStack.size() - 2) + 1;
                    break;
                } else {
                    monotonicStack.remove(monotonicStack.size() - 1);  // 如果不大于栈顶元素小 删除栈顶元素
                }
            }
        }
        monotonicStack.clear();
        // 从右往左遍历获得 存放离右边小于当前元素最近的元素的左一个元素
        for (int i = heights.length - 1; i >= 0; i--) {
            while (true) {
                if (monotonicStack.isEmpty()) { // 如果为空入栈
                    monotonicStack.add(i);
                    right[i] = heights.length - 1;
                    break;
                } else if (heights[monotonicStack.get(monotonicStack.size() - 1)] < heights[i]) {
                    monotonicStack.add(i);
                    right[i] = monotonicStack.get(monotonicStack.size() - 2) - 1;
                    break;
                } else {
                    monotonicStack.remove(monotonicStack.size() - 1);  // 如果不大于栈顶元素小 删除栈顶元素
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (maxArea < (right[i] - left[i] + 1) * heights[i]) {
                maxArea = (right[i] - left[i] + 1) * heights[i];
            }
        }
        return maxArea;
    }

    // 使用单调栈解法
    public int largestRectangleArea3(int[] heights) {
        ArrayDeque<Integer> monotonicStack = new ArrayDeque<>();
        int[] left = new int[heights.length]; // 存放离左边小于当前元素最近的元素的右一个元素
        int[] right = new int[heights.length]; // 左边换成右边同理

        // 从左往右遍历获得 存放离左边小于当前元素最近的元素的右一个元素
        for (int i = 0; i < heights.length; i++) {
            while (true) {
                if (monotonicStack.isEmpty()) { // 如果为空入栈
                    monotonicStack.push(i);
                    left[i] = 0;
                    break;
                } else if (heights[monotonicStack.peek()] < heights[i]) {
                    left[i] = monotonicStack.peek() + 1;
                    monotonicStack.push(i);
                    break;
                } else {
                    monotonicStack.pop();  // 如果不大于栈顶元素小 删除栈顶元素
                }
            }
        }
        monotonicStack.clear();
        // 从右往左遍历获得 存放离右边小于当前元素最近的元素的左一个元素
        for (int i = heights.length - 1; i >= 0; i--) {
            while (true) {
                if (monotonicStack.isEmpty()) { // 如果为空入栈
                    monotonicStack.push(i);
                    right[i] = heights.length - 1;
                    break;
                } else if (heights[monotonicStack.peek()] < heights[i]) {
                    right[i] = monotonicStack.peek()  - 1;
                    monotonicStack.push(i);
                    break;
                } else {
                    monotonicStack.pop();  // 如果不大于栈顶元素小 删除栈顶元素
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (maxArea < (right[i] - left[i] + 1) * heights[i]) {
                maxArea = (right[i] - left[i] + 1) * heights[i];
            }
        }
        return maxArea;
    }
}
