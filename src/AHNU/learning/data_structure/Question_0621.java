package AHNU.learning.data_structure;

/*
    给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
    然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
    你需要计算完成所有任务所需要的 最短时间 。

    示例 1：
        输入：tasks = ["A","A","A","B","B","B"], n = 2
        输出：8
        解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
        在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
    示例 2：
        输入：tasks = ["A","A","A","B","B","B"], n = 0
        输出：6
        解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
        ["A","A","A","B","B","B"]
        ["A","B","A","B","A","B"]
        ["B","B","B","A","A","A"]
        ...
        诸如此类
    示例 3：
        输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
        输出：16
        解释：一种可能的解决方案是：
         A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/task-scheduler
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question_0621 {

    public static void main(String[] args) {
        Question_0621 q = new Question_0621();
        char[] tasks = new char[]{'a', 'a', 'a', 'b', 'b', 'b'};
        System.out.println(q.leastInterval(tasks, 2));
    }


    // 策略是 执行当前可执行的剩余次数最多的任务
    public int leastInterval(char[] tasks, int n) {
        // 记录剩余的任务
        Map<Character, Integer> map = new LinkedHashMap<>();
        // 记录任务是否可执行
        Map<Character, Integer> round = new LinkedHashMap<>();
        int result = 0;

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        while (!map.isEmpty()){
            // 寻找要执行的任务
            int max = -1;
            Character task = null;
            for (Character key : map.keySet()) {
                if (map.get(key) > max && !round.containsKey(key)){
                    max = map.get(key);
                    task = key;
                }
            }
            if (task != null){
                round.put(task,n+1);
                if (map.put(task,map.get(task) -1) <= 1){
                    map.remove(task);
                }
            }
            result++;
            // TODO： 可以把round修改为下一次该任务执行的最早时间是多少来去掉这层遍历  并且记录这个最小值
            //  当前时间小于round中的最小值时可以直接跳过循环 减少待命状态无必要的遍历
            // 改变记录间隔轮数的map
            // foreach 不允许元素数量发生变动 使用迭代器的remove方法
            Iterator<Character> it = round.keySet().iterator();
            while (it.hasNext()){
                Character key = it.next();
                if (round.put(key,round.get(key)-1) <= 1){
                    it.remove();
                }
            }
        }
        return result;
    }
}



