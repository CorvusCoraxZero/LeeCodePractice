package AHNU.learning.data_structure;

/*
    给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays

*/

import java.util.Scanner;

public class Question_0004 {

    public static void main(String[] args) {
        int[] num1 = {1};
        int[] num2 = {2,3,4,5,6,7,8};
        Question_0004 q4 = new Question_0004();

        System.out.println(q4.findMedianSortedArrays(num1, num2));
    }

    // 一个一个排序查找 时间复杂度O（m+n）
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {  // 应付空数组的情况
            if ((nums2.length + 1) % 2.0 == 0) {
                return nums2[((nums2.length + 1) / 2) - 1];
            } else return (nums2[((nums2.length + 1) / 2) - 1] + nums2[((nums2.length + 1) / 2)]) / 2.0;
        }
        if (nums2.length == 0) {
            if ((nums1.length + 1) % 2.0 == 0) {
                return nums1[((nums1.length + 1) / 2) - 1];
            } else return (nums1[((nums1.length + 1) / 2) - 1] + nums1[((nums1.length + 1) / 2)]) / 2.0;
        }

        double mindex = (nums1.length + nums2.length + 1) / 2.0;
        int[] median = new int[2];
        int i1 = 0, i2 = 0;
        boolean isInt = true;
        if (!((int) mindex == mindex)) {  // mindex不是整数
            isInt = false;
            mindex = Math.floor(mindex);
        }
        for (int i = 0; (i < mindex - 1); i++) { // 将坐标移动到中位数之前
            if (nums1[i1] < nums2[i2]) {
                i1++;
                if (nums1.length <= i1) {  // 防止下标越界
                    nums1[--i1] = Integer.MAX_VALUE;
                }
            } else {
                i2++;
                if (nums2.length <= i2) {
                    nums2[--i2] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < (isInt ? 1 : 2); i++) {
            if (nums1[i1] < nums2[i2]) {
                median[i] = nums1[i1++];
                if (nums1.length <= i1) {  // 防止下标越界
                    nums1[--i1] = Integer.MAX_VALUE;
                }
            } else {
                median[i] = nums2[i2++];
                if (nums2.length <= i2) {
                    nums2[--i2] = Integer.MAX_VALUE;
                }
            }
        }

        if (isInt) {
            return median[0];
        } else return (median[0] + median[1]) / 2.0;
    }*/

    // 二分查找 O(log(m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        //中位数 = （left + right）/2 这个是一个小trick 可以使得无论总长度是奇数还是偶数情况一样
        int left = (l1 + l2 + 1) / 2;
        int right = (l1 + l2 + 2) / 2;
        return (indexOfKth(nums1, 0, nums2, 0, left) + indexOfKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int indexOfKth(int[] nums1, int n1, int[] nums2, int n2, int k) { // 查找第K个元素 n1,n2为数组的起始位置
        if (nums1.length == 0 || nums1.length <= n1){
            return nums2[n2+k-1];
        }
        if (nums2.length == 0 || nums2.length <= n2){
            return nums1[n1+k-1];
        }
        if (k == 1) {
            return Math.min(nums1[n1], nums2[n2]);
        }
        //看看有没有数组长度比k/2小的 先去除掉另一个数组前面多余的元素
        if (nums1.length - n1 < k / 2) {
            n2 += k - (nums1.length - n1) - 1;
            k -= k - (nums1.length - n1) - 1;
            //n2 += k = k - (nums1.length - n1) -1;
            return indexOfKth(nums1, n1, nums2, n2, k);
        } else if (nums2.length - n2 < k / 2) {
            n1 += k - (nums2.length - n2) - 1;
            k -= k - (nums2.length - n2) - 1;
            //n1 += k = k - (nums1.length - n2) -1;
            return indexOfKth(nums1, n1, nums2, n2, k);
        }
        //去掉第k/2个数较小的数组的前k/2个数
        if (nums2[n2+k/2-1] > nums1[n1+k/2-1]) {
            n1 += k / 2;
        } else {
            n2 += k / 2;
        }
        k = k - k / 2;

        return indexOfKth(nums1, n1, nums2, n2, k);
    }
}
