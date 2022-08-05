package AHNU.learning.data_structure;

/*
   使用泛型编写一个堆
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeValueStack<E> {
    // 底层存储结构
    private E[] elements;
    private int size;
    private final int INIT_SIZE = 16;

    @SuppressWarnings("unchecked")
    public TypeValueStack() {
        elements = (E[]) new Object[INIT_SIZE];
    }

    public void push(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E pop() {
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        TypeValueStack<Integer> stack = new TypeValueStack<>();
        stack.push(88);
        stack.push(66);
        System.out.println(stack.pop());
    }
}

