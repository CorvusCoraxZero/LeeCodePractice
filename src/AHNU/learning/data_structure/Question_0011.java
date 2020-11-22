package AHNU.learning.data_structure;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
*/


public class Question_0011 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Question_0011 q = new Question_0011();
        System.out.println(q.maxArea(height));
        System.out.println(q.maxArea2(height));
    }

    //暴力解法
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                if ((Math.min(height[i], height[j]) * (j - i)) > max) {
                    max = Math.min(height[i], height[j]) * (j - i);
                }
            }
        }
        return max;
    }

    //双指针法
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] > height[right]) {
                right--;
            } else left++;
            if (max < Math.min(height[left], height[right]) * (right - left)) {
                max = Math.min(height[left], height[right]) * (right - left);
            }
        }
        return max;
    }
}
