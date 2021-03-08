package AHNU.learning.data_structure;

/*
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question_0128 {

    public static void main(String[] args) {
        Question_0128 q = new Question_0128();
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(q.longestConsecutive(nums));
    }

    // 采用HashMap解题
    public int longestConsecutive(int[] nums) {
        //生成HashMap
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,true);
        }
        //遍历nums计算最大连续数字长度
        int maxLength = 0;
        for (int num : nums) {
            //首先判断当前数字是不是连续数字的开头 如果nums中存在比当前数字有比他小1的数字 则当前数字不是连续数字的开头
            if (map.containsKey(num-1)) continue;
            //是开头则进行遍历连续最大长度；
            int length = 1;
            while (map.containsKey(num+1)){
                length++;
                num++;
            }
            if (length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}
