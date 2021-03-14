package AHNU.learning.data_structure;

/*
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    进阶：
        尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

    示例 2：
        输入：[2,2,1,1,1,2,2]
        输出：2

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/majority-element
*/

public class Question_0169 {

    public static void main(String[] args) {
        Question_0169 q = new Question_0169();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(q.majorityElement(nums));
    }

    /**
     * 最简单的思想就是维护一个Hash表 记录每个数出现的次数  但是这显然无法满足o(1)的空间复杂度
     * 又因为 该多数元素指的是出现次数大于 n/2 的元素 采用摩尔投票法解决问题
     * 该投票法的核心思想就是 如果我的得票数大于一半  就算所有人都反对我还是我赢!
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count <= 0){
                candidate = nums[i];
                count = 0;
            }
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}

