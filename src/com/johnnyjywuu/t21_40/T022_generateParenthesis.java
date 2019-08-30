package com.johnnyjywuu.t21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 22. 括号生成
 * @link https://leetcode-cn.com/problems/generate-parentheses
 * @description
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class T022_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;

        generate(result, 0, "", 0, n);

        return result;
    }

    private void generate(List<String> result, int leftParenthesisNum, String str, int i, int n) {
        if (i == n && leftParenthesisNum == 0) {
            result.add(str);
            return;
        }

        if (i < n) { //加入左括号递归
            generate(result, leftParenthesisNum + 1, str + '(', i + 1, n);
        }
        if (leftParenthesisNum != 0) { //左括号有时，字符串加入右括号，左括号数-1进行递归
            generate(result, leftParenthesisNum - 1, str + ')', i, n);
        }
    }
}
