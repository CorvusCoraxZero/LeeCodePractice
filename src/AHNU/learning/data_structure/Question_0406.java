package AHNU.learning.data_structure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*
    假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

    示例 1：
        输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        解释：
        编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
        编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
        编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
        编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
        编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。

    示例 2：
        输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
        输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
*/

public class Question_0406 {

    public static void main(String[] args) {
        Question_0406 q = new Question_0406();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] sortPeople = q.reconstructQueue2(people);
        for (int[] sortPerson : sortPeople) {
            System.out.println(sortPerson[0] + " " + sortPerson[1]);
        }
    }

    // 按顺序推算出每一个位置可能的值，因为比选定数字小的数字对选定数字的第二位排序值没有影响，所以当有多个可选的时候选择最小的可选数值。 三层循环 但是还有很大一部分可以进行剪枝
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = Arrays.stream(people).sorted((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]).collect(Collectors.toList());
        int[][] result = new int[people.length][people[0].length];
        for (int i = 0; i < people.length; i++) { // i 对应结构数组中的坐标
            for (int l = 0; l < list.size(); l++) {
                int[] ints = list.get(l);
                int tmpRank = 0; // 记录当前数字如果放入结果中排位数是多少
                for (int j = 0; j < i; j++) {
                    if (ints[0] <= result[j][0]) {
                        tmpRank++;
                    }
                }
                if (tmpRank == ints[1]) {
                    result[i] = ints;
                    list.remove(l);
                    break;
                }
            }
        }
        return result;
    }

    // O(n^2版本)
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[][] ans = new int[people.length][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
