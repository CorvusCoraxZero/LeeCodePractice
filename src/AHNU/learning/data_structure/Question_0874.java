package AHNU.learning.data_structure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 */
public class Question_0874 {

    public static void main(String[] args) {
        Question_0874 q = new Question_0874();
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(q.robotSim(commands, obstacles));
    }

    // 解答 正确 但是超时
    public int robotSim__TimeOut(int[] commands, int[][] obstacles) {
        int maxValue = 0;
        // 初始坐标
        int x = 0, y = 0;
        // 初始时面向北方
        int stateIndex = 0;
        // (fx,fy) 北 东 南 西
        int[][] fState = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 循环执行指令
        for (int comm : commands) {
            // 行走还是转向
            if (comm == -2) { // 向左
                stateIndex = (stateIndex + 3) % 4;
            } else if (comm == -1) { // 向右
                stateIndex = (stateIndex + 1) % 4;
            } else {
                // 判断是否具备行走条件
                int[] ints = fState[stateIndex];
                // 理想坐标
                int aimX = x + fState[stateIndex][0] * comm;
                int aimY = y + fState[stateIndex][1] * comm;
                // 判断路径上是否有障碍
                if (obstacles.length > 0) {
                    int finalAimX = aimX;
                    int finalAimY = aimY;
                    int finalY = y;
                    int finalX = x;
                    // 第一个filter是为了兼容 原点存在障碍物的错误用例
                    List<int[]> obList = Arrays.stream(obstacles).filter(cc -> !(cc[0] == 0 && cc[1] == 0)).filter(cc -> ((finalX <= cc[0] && cc[0] <= finalAimX) || (finalX >= cc[0] && cc[0] >= finalAimX)) && ((finalY <= cc[1] && cc[1] <= finalAimY) || (finalY >= cc[1] && cc[1] >= finalAimY))).collect(Collectors.toList());
                    if (obList.size() > 0) {
                        int[] nextOb = obList.stream().min(Comparator.comparingInt(cc -> (int) (Math.pow(cc[0] - finalX, 2) + Math.pow(cc[1] - finalY, 2)))).get();
                        aimX = nextOb[0] - fState[stateIndex][0];
                        aimY = nextOb[1] - fState[stateIndex][1];
                    }
                }

                // 移动到目标位置
                x = aimX;
                y = aimY;

                // 更新最远距离
                if ((x * x + y * y) > maxValue) {
                    maxValue = x * x + y * y;
                }
            }
        }
        return maxValue;
    }


    // 节省了遍历障碍物数组 判断是否发生碰撞的开销
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int px = 0, py = 0, d = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (int c : commands) {
            if (c < 0) {
                d += c == -1 ? 1 : -1;
                d %= 4;
                if (d < 0) {
                    d += 4;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])) {
                        break;
                    }
                    px += dirs[d][0];
                    py += dirs[d][1];
                    res = Math.max(res, px * px + py * py);
                }
            }
        }
        return res;
    }
}
