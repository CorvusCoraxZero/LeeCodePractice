package AHNU.learning.data_structure;

import java.util.Arrays;

/*
    1419. 数青蛙
    https://leetcode.cn/problems/minimum-number-of-frogs-croaking/

    给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
    请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
    要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
*/
public class Question_1419 {

    public static void main(String[] args) {
        Question_1419 q = new Question_1419();
        String input = "croakroak";
        System.out.println(q.minNumberOfFrogs(input));
    }

    // 使用队列的方法  计算出现青蛙的最大值
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] croak = new int[5];
        int result = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char tmp = croakOfFrogs.charAt(i);
            // 判断当前字符是否允许存入数组 只有c > r > o > a > x的情况才允许存入
            int index = -1;
            switch (tmp) {
                case 'c':
                    index = 0;
                    break;
                case 'r':
                    index = 1;
                    break;
                case 'o':
                    index = 2;
                    break;
                case 'a':
                    index = 3;
                    break;
                case 'k':
                    index = 4;
                    break;
            }
            if (index == 0 ){
                // 计算corak[0]的最大值即可得到 同时吟唱的青蛙的最小值
                croak[index] += 1;
                if (result < croak[0]){
                    result = croak[0];
                }
            }
            else if (croak[index] < croak[index - 1]) {
                croak[index] += 1;
                // 表示一只青蛙吟唱结束
                if (index == 4) {
                    for (int y = 0; y < croak.length; y++) {
                        croak[y] -= 1;
                    }
                }
            }else {
                return -1;
            }
        }

        // 判断有的青蛙没有吟唱完成的情况
        for (int i = 1; i < croak.length; i++) {
            if (croak[i] - croak[i - 1] != 0) {
                return -1;
            }
        }
        return result;
    }

}
