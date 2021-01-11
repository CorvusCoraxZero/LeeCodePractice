package AHNU.learning.data_structure;

/*
    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

    进阶：
        你可以不使用代码库中的排序函数来解决这道题吗？
        你能想出一个仅使用常数空间的一趟扫描算法吗？
     
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sort-colors
*/

public class Question_0075 {

    public static void main(String[] args) {
        Question_0075 q = new Question_0075();
        int[] nums = new int[]{1,2,0};
        q.sortColors2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /* 简单粗暴 直接扫描一遍记录个数 然后赋值 */
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = red; i < red + white; i++) {
            nums[i] = 1;
        }
        for (int i = red + white; i < red + white + blue; i++) {
            nums[i] = 2;
        }
    }

    /* 使用头尾两个指针 发现0换到前面来 发现2换到后面去 但由于不知道后面的当前坐标上的是否也是2 所以要一直重复这个步骤直到换回来的不是2为止*/
    public void sortColors2(int[] nums) {
        int head = 0, tail = nums.length - 1,temp;
        for (int i = 0; i < nums.length; i++) {
            if (i > tail) break;
            if(nums[i] == 2){
                while (true){
                    temp = nums[tail];
                    nums[tail] = nums[i];
                    nums[i] = temp;
                    tail--;
                    if (nums[i] != 2 || tail < i) break;;
                }
            }
            if (nums[i] == 0) {
                temp = nums[head];
                nums[head] = nums[i];
                nums[i] = temp;
                head++;
            }
        }
    }
}
