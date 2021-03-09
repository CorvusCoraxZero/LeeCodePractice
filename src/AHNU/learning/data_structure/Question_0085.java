package AHNU.learning.data_structure;

/*
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    求在该柱状图中，能够勾勒出来的矩形的最大面积。
*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Question_0085 {

    public static void main(String[] args) {
        Question_0085 q = new Question_0085();
        //char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = new char[][]{{'0','1'},{'1','0'}};
        System.out.println(q.maximalRectangle(matrix));
    }


    // 使用单调栈解法 制作一张表 用于存放该单元格上方连续的为1的矩阵的数量 然后按行执行84题的解法（将85题划分成为多个84题）
    public int maximalRectangle(char[][] matrix){//(int[] heights) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[][] heights = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ('1' == matrix[i][j]){
                    if (i == 0){
                        heights[i][j] = 1;
                    }else {
                        heights[i][j] = heights[i-1][j] + 1;
                    }
                }
            }
        }
        for (int x = 0; x < heights.length; x++) {
            ArrayDeque<Integer> monotonicStack = new ArrayDeque<>();
            int[] left = new int[heights[0].length]; // 存放离左边小于当前元素最近的元素的右一个元素
            int[] right = new int[heights[0].length]; // 左边换成右边同理

            // 从左往右遍历获得 存放离左边小于当前元素最近的元素的右一个元素
            for (int i = 0; i < heights[0].length; i++) {
                while (true) {
                    if (monotonicStack.isEmpty()) { // 如果为空入栈
                        monotonicStack.push(i);
                        left[i] = 0;
                        break;
                    } else if (heights[x][monotonicStack.peek()] < heights[x][i]) {
                        left[i] = monotonicStack.peek() + 1;
                        monotonicStack.push(i);
                        break;
                    } else {
                        monotonicStack.pop();  // 如果不大于栈顶元素 删除栈顶元素
                    }
                }
            }
            monotonicStack.clear();
            // 从右往左遍历获得 存放离右边小于当前元素最近的元素的左一个元素
            for (int i = heights[0].length - 1; i >= 0; i--) {
                while (true) {
                    if (monotonicStack.isEmpty()) { // 如果为空入栈
                        monotonicStack.push(i);
                        right[i] = heights[x].length - 1;
                        break;
                    } else if (heights[x][monotonicStack.peek()] < heights[x][i]) {
                        right[i] = monotonicStack.peek()  - 1;
                        monotonicStack.push(i);
                        break;
                    } else {
                        monotonicStack.pop();  // 如果不大于栈顶元素 删除栈顶元素
                    }
                }
            }

            for (int i = 0; i < heights[0].length; i++) {
                if (maxArea < (right[i] - left[i] + 1) * heights[x][i]) {
                    maxArea = (right[i] - left[i] + 1) * heights[x][i];
                }
            }
        }
        return maxArea;
    }
}
