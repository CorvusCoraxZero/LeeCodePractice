package AHNU.learning.data_structure;

/*
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    此外，你可以假设该网格的四条边均被水包围。

    输入：grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    输出：3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/number-of-islands
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class Question_0200 {

    public static void main(String[] args) {
        Question_0200 q = new Question_0200();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(q.numIslands(grid));
    }

    /**
     * 尝试使用 深度优先探索 解题 探索过的地方就标记为'0' 对所有标记为'1'的地方进行探索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 递归实现的深度优先探索
     */
    public void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            bfs(grid, x - 1, y);
        }
        if (x + 1 <= grid.length - 1 && grid[x + 1][y] == '1') {
            bfs(grid, x + 1, y);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            bfs(grid, x, y - 1);
        }
        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == '1') {
            bfs(grid, x, y + 1);
        }
        return;
    }
}

