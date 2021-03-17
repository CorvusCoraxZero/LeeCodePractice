package AHNU.learning.data_structure;

/*
    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/course-schedule
*/

import java.util.*;

public class Question_0207 {

    public static void main(String[] args) {
        Question_0207 q = new Question_0207();
        int[][] course = {{1, 0}};
        System.out.println(q.canFinishBfs(2, course));
    }


    /**
     * 看了题解 用拓扑排序 的方法
     * 用dfs判断图中是否存在环结构 如果存在环结构则说明这是一个无法完成的课程安排
     * 最终从栈顶到栈底的序列就是一种拓扑排序。
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges;      // 邻接矩阵
        int[] visited;                  // 记录元素被访问的状态
        boolean valid = true;

        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>()); // 徍图中加入顶点
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {  // 徍图中加入边
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                valid = dfs(i, visited, edges);
            }
        }
        return valid;
    }

    public boolean dfs(int index, int[] visited, List<List<Integer>> edges) {                 // 记录元素被访问的状态
        visited[index] = 1;
        for (Integer integer : edges.get(index)) {
            if (visited[integer] == 0) {
                if (!dfs(integer, visited, edges)) {  // 接着往下遍历
                    return false;
                }
            } else if (visited[integer] == 1) {
                return false;
            }
        }
        visited[index] = 2;

        return true;
    }

    /**
     * 看了题解 用拓扑排序 的方法
     * BFS来遍历图 将入度为0的节点 放入遍历的队列中
     * 最终出队的序列序列就是一种拓扑排序。
     */
    public boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>(); // 邻接矩阵记录图
        int[] entry = new int[numCourses];      // 记录节点的入度
        ArrayDeque deque = new ArrayDeque();    // bfs的队列

        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>()); // 徍图中加入顶点
        }
        for (int[] info : prerequisites) {  // 徍图中加入边 记录节点的入度
            edges.get(info[1]).add(info[0]);
            entry[info[0]]++;
        }
        // BFS
        for (int i = 0; i < numCourses; i++) {  //  将入度为0的节点放入队列中
            if (entry[i] == 0) {
                deque.offer(i);
            }
        }
        int visited = 0;
        while (!deque.isEmpty()) {
            int learn = (int) deque.pop();
            visited++;
            for (Integer i : edges.get(learn)) {
                if (--entry[i] == 0) {
                    deque.offer(i);
                }
            }
        }

        return visited == numCourses;
    }
}

