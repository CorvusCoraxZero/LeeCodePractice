package AHNU.learning.data_structure;

/*
   给一个01的字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1，现在问最大的可能答案.

    输入描述
        输入第一行两个整数N,K，表示字符串长度和机会次数
        第二行输入N个整数，表示该字符串的元素

        1 <= N <= 3*10^5 ， 0 <= K <= N

    输出描述
        输出仅一行，表示答案
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Saima_0002 {  // testset

    // ❌ 动态规划硬解 不是不行 太麻烦且耗时
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int chance = sc.nextInt();
        String str = sc.nextLine();

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>();

        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                temp++;
            }else {
                if (temp != 0){
                    list.add(temp);
                }
                list.add(0);
                index.add(list.size() - 1);
            }
        }
        // 两组动态规划
        // 一组记录左边 dp[i][j] 表示第i个1插入道j位置 左边连着的1最多有多少位
        // 一组记录右边
    }

    // 推断出解题关键 两个新加入的1必然是连着的 使用双指针法 滑动窗口  搜索
    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int res = getAns(arr, N, K);
        System.out.println(res);
    }

    public static int getAns(int[] arr, int N, int K) {
        int left = 0, right = 0, res = 0;
        while (right < N) {
            if (arr[right] == 0) {
                K--;
            }
            while (K < 0) {
                if (arr[left] == 0) {
                    K++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}



