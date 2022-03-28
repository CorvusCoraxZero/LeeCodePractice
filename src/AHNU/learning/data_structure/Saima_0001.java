package AHNU.learning.data_structure;

/*
    题目描述：
        给定一个字符串，问是否能够通过添加一个字母将其变成“回文串”。 “回文串”是指正着和反着读都一样的字符串。如：”aa”,”bob”,”testset”是回文串，”alice”,”time”都不是回文串。
    输入：
        一行一个有小写字母构成的字符串，字符串长度不超过10。
    输出：
        如果输入字符串可以通过添加一个字符，则输出”YES”，否则输出”NO”。

*/

import java.util.Arrays;
import java.util.Scanner;

public class Saima_0001 {  // testset

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int head = 0;
        int tail = str.length()-1;
        boolean flag = false;

        if (str.length() < 2){
            System.out.println("Yes");
            return;
        }

        // 找到第一个不一致的地方
        while (head < tail){
            if (str.charAt(head) == str.charAt(tail)){
                head++;
                tail--;
            }else {
                break;
            }
        }
        if (head >= tail){
            System.out.println("Yes");
            return;
        }
        // 左边砍掉一个
        int newhead = head+1;
        int newtail = tail;
        while (newhead < newtail){
            if (str.charAt(newhead) == str.charAt(newtail)){
                newhead++;
                newtail--;
            }else {
                break;
            }
        }
        if (newhead >= newtail){
            System.out.println("Yes");
            return;
        }
        // 右边砍掉一个
        newhead = head;
        newtail = tail-1;
        while (newhead < newtail){
            if (str.charAt(newhead) == str.charAt(newtail)){
                newhead++;
                newtail--;
            }else {
                break;
            }
        }
        if (newhead >= newtail){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
        return;
    }
}



