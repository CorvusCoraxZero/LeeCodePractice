package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

    示例 1：
        输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        输出：3
        解释：和等于 8 的路径有 3 条，如图所示。

    示例 2：
        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/path-sum-iii
*/

public class Question_0437 {

    public static void main(String[] args) {
        Question_0437 q = new Question_0437();
        TreeNode node = TreeNode.getTreeLayer();
        // 10 5 -3 3 2 ! 11 3 -2 ! 1 #
        // 5 4 8 11 ! 13 4 7 2 ! ! 5 1 #
        System.out.println(q.pathSum(node, 22));
    }

    // 使用先序遍历 然后记录 栈路径上的以每个节点到当前节点的数值
    private static int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        prc(root,targetSum,list);
        return result;
    }

    // 先序遍历
    public void prc(TreeNode root, int target, List<Integer> record) {
        Integer temp = new Integer(root.val);
        if (temp == target) result++;
        for (int i = 0; i < record.size(); i++) {
            record.set(i,record.get(i)+temp);
            if (record.get(i) == target){
                result++;
            }
        }
        record.add(temp);
        if (root.left != null){
            prc(root.left, target, record);
        }
        if (root.right != null){
            prc(root.right, target, record);
        }
        record.remove(temp);
        for (int i = 0; i < record.size(); i++) {
            record.set(i,record.get(i)-temp);
        }
    }
}



