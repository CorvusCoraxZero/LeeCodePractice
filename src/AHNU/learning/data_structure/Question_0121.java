package AHNU.learning.data_structure;

/*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    输入：[7,1,5,3,6,4]
    输出：5

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
*/


import java.util.ArrayDeque;

public class Question_0121 {

    public static void main(String[] args) {
        Question_0121 q = new Question_0121();
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(q.maxProfit(a));
    }

    /**
     * 单调栈解法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            while (true){
                if (stack.isEmpty()){
                    stack.push(prices[i]);
                    break;
                }else if (stack.peek() < prices[i]){
                    stack.push(prices[i]);
                    if (max < stack.peek() - stack.peekLast()){
                        max = stack.peek() - stack.peekLast();
                    }
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        return max;
    }

    /**
     * 用单调栈解决该问题 有些大材小用
     * 使用记录最低点的解法 记录之前的天数里的最低点 与现在的价格比较 得出最大的利润
     * @param prices
     * @return
     */
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
