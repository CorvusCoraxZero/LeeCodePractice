package AHNU.learning.data_structure;

/*
   在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    示例 1:
        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5

    示例 2:
        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
        输出: 4

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array

*/

import java.util.Arrays;

public class Question_0215 {

    public static void main(String[] args) {
        Question_0215 q = new Question_0215();
        int[] nums = new int[]{5, 2, 8, 4, 6, 7, 1, 3, 9, 0};
        int[] nums2 = new int[]{3, 2, 1, 5, 6, 4};

        System.out.println(q.findKthLargest2(nums, 3));
    }

    // 快排解题
    public int findKthLargest(int[] nums, int k) {
        QuickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void QuickSort(int[] nums, int start, int end) {
        if (end - start <= 0) return;
        int low = start, high = end;
        int base = nums[start];
        while (low < high) {
            while (low < high && nums[high] > base) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= base) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = base;

        QuickSort(nums, start, high - 1);
        QuickSort(nums, high + 1, end);
    }


    // 堆排序解题
    public int findKthLargest2(int[] nums, int k) {
        //1.构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(nums, 0, j);//重新对堆进行调整
        }

        return nums[nums.length - k];
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    public static void adjustHeap(int[] nums, int i, int length) {  // 在i后元素以为大顶堆的前提下 找到 i 元素该待在的位置
        int sentry = nums[i]; // 记录传入的节点的值
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) { // 首先检查该节点的左孩子节点
            if (j + 1 < length && nums[j] < nums[j+1]){ // j取为左右孩子节点中最大的节点
                j++;
            }
            if (nums[j] > sentry){  // 如果比孩子节点小 则孩子节点上移到父节点 i 上
                nums[i] = nums[j];
                i = j;
            }else{
                break;
            }
        }
        nums[i] = sentry;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
