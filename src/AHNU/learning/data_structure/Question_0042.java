package AHNU.learning.data_structure;

/*
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/trapping-rain-water
*/

import java.util.*;

public class Question_0042 {

    public static void main(String[] args) {
        Question_0042 q = new Question_0042();

        int[] height = {2,1,1,2};
        System.out.println(q.trap2(height));

    }

    // (也就是最直观的解法优化)尝试使用回溯法解  遇见一个柱子往右边找比他高的或者等高的 亦或者是这之后最高的
    public int trap(int[] height) {
        int left = 0, right = 0;  // 表示左边，右边柱子的坐标
        int count = 0, temp;

        while (true) {
            if (left >= height.length - 1) {  // 左边走到尽头 结束循环
                break;
            }
            //往右寻找 看有没有和他一样或者比它高的柱子 或者是这之后最高的柱子
            if (height[left] == 0) {
                left++;
                continue;
            }
            temp = left + 1; // 记住这之后最高的柱子的坐标
            for (right = left + 1; right < height.length; right++) {
                if (height[temp] < height[right]) {
                    temp = right;
                }
                if (height[left] <= height[right]) {
                    break;
                }
            }
            if (right == temp) { // 如果找到更高的或者相同的
                // 计算积水面积
                temp = Math.min(height[left], height[right]) * (right - left - 1);  // 如果没有中间的柱子的积水数量
                for (int i = left + 1; i <= right - 1; i++) {
                    temp -= height[i];
                }
                count += temp;
                // 移动坐标
                left = right;
            } else { //如果没有更高的 left往右移动一格继续搜索
                right = temp;
                // 计算积水面积
                temp = Math.min(height[left], height[right]) * (right - left - 1);  // 如果没有中间的柱子的积水数量
                for (int i = left + 1; i <= right - 1; i++) {
                    temp -= height[i];
                }
                count += temp;
                // 移动坐标
                left = right;
            }
        }
        return count;
    }

    //栈的解法 解法一的优化
    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    // 动态编程的解法 获得两个数组 分别是从左往右扫描和从右往左扫描保存当前位置和上一位置相比的最大值 然后两个数组分别取最小值再减去柱子的高度即使结果
    public int trap3(int[] height) {
        int[] leftmax = new int[height.length];   // 从左往右取最大
        int[] rightmax = new int[height.length];  // 从右往左取最大
        int count = 0; // 结果

        if (height.length <= 2) return 0;

        //从左往右取最大
        leftmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }
        //从右往左取最大
        rightmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
        //再两个数组取最小 - 柱子高度
        for (int i = 0; i < height.length; i++) {
            count += Math.min(leftmax[i],rightmax[i]) - height[i];
        }
        return count;
    }

    // 双指针法 上面方法的优化版 效率更高
    public int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
