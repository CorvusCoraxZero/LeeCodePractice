package AHNU.learning.data_structure;

import java.util.*;

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

    public static TreeNode getTreeLayer(){
        System.out.println("层次创建二叉树 使用 ! 表示 null，使用 # 表示结束： ");
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
            }else if (n.equals("!")){
                t.left = null;
            }else{
                t.left = new TreeNode(Integer.parseInt(n));
                stack.add(t.left);
            }
            n = sc.next();
            if (n.equals("#")){
                return root;
            }else if (n.equals("!")){
                t.right = null;
            }else{
                t.right = new TreeNode(Integer.parseInt(n));
                stack.add(t.right);
            }
        }
    }

    // 郭佳鑫_TODO 2022/8/13 : 通过leecode的方法创建
    // 返回层次遍历创建的二叉树
    public static TreeNode getTreeLayer(String input){
        System.out.println("层次创建二叉树 使用 ! 表示 null，使用 # 表示结束： ");
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
            }else if (n.equals("!")){
                t.left = null;
            }else{
                t.left = new TreeNode(Integer.parseInt(n));
                stack.add(t.left);
            }
            n = sc.next();
            if (n.equals("#")){
                return root;
            }else if (n.equals("!")){
                t.right = null;
            }else{
                t.right = new TreeNode(Integer.parseInt(n));
                stack.add(t.right);
            }
        }
    }

    // 先序遍历创建二叉树
    public static TreeNode getTreeFirst() {
        System.out.println("先序创建二叉树 数字表示值 null表示空： ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] split = data.split("[' ']+");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(split));
        TreeNode root = createTree(list);
        return root;
    }

    private static TreeNode createTree(ArrayList list) {
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

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {  // 如果root不为空就把左节点一路遍历到底 并且把节点存入栈中
                stk.push(root);
                root = root.left;
            }
            root = stk.pop(); // 此时节点为null pop一个栈中的节点作为根节点 并把节点数据存入list
            res.add(root.val);
            root = root.right; // 看此时的节点有没有右节点
        }
        return res;
    }
}
