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

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLamda {  // testset

    String name = "TestLamda";

    public static void main(String[] args) {
        new TestLamda().run();
    }
    public void run(){
        A a = new A(() -> this.name);
        a.say();

    }

}

class A{
    String name = "A";
    private Supplier<String> f;

    public A(Supplier<String> f) {
        this.f = f;
    }

    public void say(){
        System.out.println(f.get());
    }
}