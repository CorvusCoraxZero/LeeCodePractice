package AHNU.learning.data_structure;

/*
    寻找最长V串，满足一下条件的数组，即为V形数组：
    · 长度不小于3
    · 在0 < i < arr.length - 1条件下，存在i使得：
        arr[0] > arr[1] >...a[i-1] > a[i]
        arr[i] < arr[i+1] <...<arr[arr.length-1]
    · 索引i两边的项数可以不相等
    给定一个证书组，返回最长的V形连续子数组的长度，没有就返回0

    示例：
        输入：9 //数组长度
             3 2 1 2 1 4 7 5 4
        输出：4
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Saima_0003 {  // testset

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = 0, current = 1;
        boolean up = false, equals = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (up || equals) {
                    if (up) {
                        result = Math.max(result, current);
                    }
                    up = false;
                    equals = false;
                    current = 1;
                }
                current++;
            } else if (nums[i] > nums[i - 1]) {
                if (!equals && current > 1) {
                    current++;
                    up = true;
                    result = Math.max(result, current);

                }
            } else {
                equals = true;
            }
        }

        System.out.println(result);
    }


}



