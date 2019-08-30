package com.johnnyjywuu.t41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title
 * @link https://leetcode-cn.com/problems/n-queens
 * @description
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/8-queens.png
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */

public class T051_solveNQueens {
    private List<List<String>> result = new ArrayList<>();
    //皇后位置，行为角标，列为数值，例：queens[1] = 3;代表第2行第4列上有queen，这么做是为了减少使用空间，不用一维或二维数组存储棋盘而是以此来指示，空间由O(n^2)降为O(n)
    private int[] queens;
    //由于queens的储存方式可保证每列仅一个queen
    //以下三个数组用于储存哪些行、正斜、反斜可被已有的queen攻击，true可被攻击，false不可被攻击
    private boolean[] rows;
    //https://pic.leetcode-cn.com/332b878ebcd261a71f5f85cb4e23685d42b37685112f562e2844079748e63cd0-51_diagonals.png
    private boolean[] dales; //正斜，行号 - 列号 = 常数
    private boolean[] hills; //反斜，行号 + 列号 = 常数
    private int n;

    private void palceQueen(int row, int col) { //放置皇后
        queens[row] = col; //row行col列放置queen
        rows[col] = true; //该点所在的第col列可被攻击
        dales[row - col + (n - 1)] = true; //该点所在正斜可被攻击，放置时由于数组脚标不能为负，因此每个脚标+(n-1)进行计算
        hills[row + col] = true; //该点所在反斜可被攻击
    }

    private void removeQueen(int row, int col) { //移除皇后，回溯用
        queens[row] = 0;
        rows[col] = false;
        dales[row - col + (n - 1)] = false;
        hills[row + col] = false;
    }

    private boolean isNotUnderAttack(int row, int col) {
        return !rows[col] && !dales[row - col + (n - 1)] && !hills[row + col];
    }

    private void addResult() { //生成结果
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j ++) {
                stringBuilder.append((j == queens[i]) ? 'Q' : '.');
            }
            solution.add(stringBuilder.toString());
        }
        result.add(solution);
    }

    private void backtrack(int row) { //按行递归，保证每行仅有一个queen
        for (int col = 0; col < n; col ++) { //对该行每一个点尝试放置queen
            if (isNotUnderAttack(row, col)) { //该点安全时，尝试放置queen，然后递归下一行
                palceQueen(row, col);
                if (row + 1 == n) { //row到最后一行，得解
                    addResult();
                } else {
                    backtrack(row + 1);
                }
                //回溯
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        rows = new boolean[n];
        dales = new boolean[n * 2 - 1]; //正斜共n*2-1条，每个脚标代表每条反斜上row-col值，值范围为(1-n)~(n-1)共，(n-1)*2+1=n*2-1个
        hills = new boolean[n * 2 - 1]; //反斜共n*2-1条，每个脚标代表每条反斜上row+col值，值范围为0~(n-1)*2共，(n-1)*2+1=n*2-1个

        backtrack(0);

        return result;
    }
}
