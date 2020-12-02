package AHNU.learning.data_structure;

/*
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/trapping-rain-water
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_0042 {

    public static void main(String[] args) {
        Question_0042 q = new Question_0042();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(q.trap(height));

    }

    // 尝试使用回溯法解体  遇见一个柱子往右边找比他高的或者等高的
    public int trap(int[] height) {
        int left = 0, right = 0;  // 表示左边，右边柱子的坐标
        int count = 0, temp;
        while (true) {
            if (left >= height.length - 1) {  // 左边走到尽头 结束循环
                break;
            }
            //往右寻找 看有没有和他一样或者比它高的柱子
            if (height[right] == 0) {
                right++;
                continue;
            }
            for (right = left + 1; right < height.length - 1; right++) {
                if (height[left] <= height[right]) {
                    break;
                }
            }
            if (left >= height.length - 1) { // 如果找到更高的或者相同的
                // 计算积水面积
                temp = Math.min(left, right) * (right - left - 1);  // 如果没有中间的柱子的积水数量
                for (int i = right + 1; i < left - 1; i++) {
                    temp -= height[i];
                }
                count += temp;
                // 移动坐标
                left = right;
            } else { //如果没有更高的 left往右移动一格继续搜索
                left++;
            }
        }
        return count;
    }
}
