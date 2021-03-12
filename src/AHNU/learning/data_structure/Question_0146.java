package AHNU.learning.data_structure;

/*
    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
    实现 LRUCache 类：

    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/lru-cache
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Question_0146 {

    public static void main(String[] args) {
        Question_0146 q = new Question_0146();

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }


}

// 使用LinkedHashMap来解题  因为LinkedHashMap既可以做到读写o(1)的时间复杂度 又可以保证有序
class LRUCache {
    HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    // 一次get()就是一次访问 为了实现LRU的特性 将每次被访问过的对象移动到链表的尾部 所以头节点的元素就是最久未访问到的元素
    public int get(int key) {
        if (map.containsKey(key)){
            int val = map.get(key); // 获取该元素
            map.remove(key);    // 移除该元素
            map.put(key,val);   // 将该元素 移动到链表的尾部
            return val;
        }
        return -1;
    }

    // 如果超过map的容量就将头节点
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
        }
        if (map.size() < capacity){  // 如果没到预设的容量直接put写入就好了
            map.put(key,value);
            return;
        }else{  // 已经到了预设的容量
            Iterator<Integer> iterator = map.keySet().iterator();
            map.remove(iterator.next());
            map.put(key,value);
            return;
        }
    }
}
