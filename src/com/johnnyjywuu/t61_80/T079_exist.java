package com.johnnyjywuu.t61_80;

/**
 * @author Created by Johnny Wu on 2019/9/3.
 * @title 79. 单词搜索
 * @link https://leetcode-cn.com/problems/word-search
 * @description
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */

public class T079_exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;

        boolean[][] isUsed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (isExist(board, word, i, j, 0, isUsed)) return true;
            }
        }

        return false;
    }

    private boolean isExist(char[][] board, String word, int i, int j, int index, boolean[][] isUsed) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j]) return false; //超边界或者已使用，返回false

        if (board[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) return true;
            isUsed[i][j] = true;
            if (isExist(board, word, i + 1, j, index + 1, isUsed)
                    || isExist(board, word, i - 1, j, index + 1, isUsed)
                    || isExist(board, word, i, j + 1, index + 1, isUsed)
                    || isExist(board, word, i, j - 1, index + 1, isUsed)) { //递归上下左右的点，找到一条路径即返回true
                return true;
            }
            //回溯
            isUsed[i][j] = false;
        }

        return false;
    }
}
