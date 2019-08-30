package com.johnnyjywuu.t41_60;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 52. N皇后 II
 * @link https://leetcode-cn.com/problems/n-queens-ii
 * @description
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/8-queens.png
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */

public class T052_totalNQueens {
    public int totalNQueens(int n) {
        return new T051_solveNQueens().solveNQueens(n).size(); //(优化51题，可节省时间空间）
    }
}
