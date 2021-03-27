package AHNU.learning.data_structure;

/*
    实现一个 Trie (前缀树，也叫字典树)，包含 insert, search, 和 startsWith 这三个操作。

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // 返回 true
    trie.search("app");     // 返回 false
    trie.startsWith("app"); // 返回 true
    trie.insert("app");
    trie.search("app");     // 返回 true

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Question_0208 {

    public static void main(String[] args) {
        Question_0208 q = new Question_0208();
        String word = "aaabc";
        String prefix = "aaa";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}

class Trie {

    private TrieNode  head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode index = head;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!index.containsKey(c)){
                index.put(c,new TrieNode());
            }
            index = index.get(c);
        }
        index.setEnd();
        return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode index = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (index.containsKey(c)){
                index = index.get(c);
            }else {
                return false;
            }
        }
        return index.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode index = head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (index.containsKey(c)){
                index = index.get(c);
            }else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {

    // R links to node children
    private final int R = 26;
    private TrieNode[] links;


    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

