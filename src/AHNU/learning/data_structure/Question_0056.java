package AHNU.learning.data_structure;

/*
    给出一个区间的集合，请合并所有重叠的区间。

    输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2:

    输入: intervals = [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-intervals
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question_0056 {

    public static void main(String[] args) {
        Question_0056 q = new Question_0056();

        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = q.merge(intervals);
        for (int[] interval : merge) {
            for (int i : interval) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

    // 先对数组进行排序 按照区间开头的大小进行排序
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        // 对二维数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int head = intervals[0][0], tail = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tail) {  //  如果该数组的开头比前面的区域最大值小 则并入前面的区域
                tail = Math.max(intervals[i][1], tail);
            } else {                        //  否则就把前面的区域塞入结果数组 设置区域的的大小为该数组
                list.add(new int[]{head, tail});;
                head = intervals[i][0];
                tail = intervals[i][1];
            }
        }
        list.add(new int[]{head, tail});

        return list.toArray(new int[list.size()][]);
    }
}
