package AHNU.learning.data_structure;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getTree(){
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(Integer.parseInt(sc.next()));
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        String n;
        while (true){
            TreeNode t = stack.pop();
            n = sc.next();
            if (n.equals("#")){
                return root;
            }else if (n.equals("-")){
                t.left = null;
            }else{
                t.left = new TreeNode(Integer.parseInt(n));
                stack.add(t.left);
            }
            n = sc.next();
            if (n.equals("#")){
                return root;
            }else if (n.equals("-")){
                t.right = null;
            }else{
                t.right = new TreeNode(Integer.parseInt(n));
                stack.add(t.right);
            }

        }
    }
}
