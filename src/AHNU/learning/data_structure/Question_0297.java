package AHNU.learning.data_structure;

/*
    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

    示例 1：
        输入：root = [1,2,3,null,null,4,5]
        输出：[1,2,3,null,null,4,5]
    示例 2：
        输入：root = []
        输出：[]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question_0297 {

    public static void main(String[] args) {
        Question_0297 q = new Question_0297();
//        TreeNode tree = TreeNode.getTree();
        Codec codec = new Codec();
//        System.out.println(codec.serialize(tree));

        System.out.println(codec.serialize(codec.deserialize("1 2 3 null null 4 null null 5 null null")));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // 线序遍历 解码二叉树胡
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        decodeTree(root, sb);
        return sb.toString();
    }

    private void decodeTree(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append("null ");
        } else {
            sb.append(root.val + " ");
            decodeTree(root.left,sb);
            decodeTree(root.right,sb);
        }
        return;
    }

    // 先序遍历创建二叉树
    public TreeNode deserialize(String data) {
        String[] split = data.split("[' ']+");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(split));
        TreeNode root = createTree(list);
        return root;
    }

    private TreeNode createTree(ArrayList list) {
        if ("null".equals((list.get(0)))) {
            list.remove(0);
            return null;
        } else {
            int num = Integer.parseInt((String) list.remove(0));
            TreeNode node = new TreeNode(num);
            node.left = createTree(list);
            node.right = createTree(list);
            return node;
        }
    }
}
