package com.johnnyjywuu.t0_20;

import java.util.Stack;

/**
 * @author Created by Johnny Wu on 2019/8/23.
 * @title 20. 有效的括号
 * @link https://leetcode-cn.com/problems/valid-parentheses
 * @description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */

public class T020_isValid {
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {// 左括号直接入栈
                stack.push(ch);
            }
            if (ch == ')' || ch == ']' || ch == '}') {// 右括号则判断栈顶是否为对应左括号，是则出栈顶，否则返回false
                switch (ch) {
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }

        if (!stack.isEmpty()) return false;// 若此时栈不为空，说明还有未配对的括号，返回false

        return true;
    }
}
