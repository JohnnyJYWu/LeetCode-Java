package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/22.
 * @title 6. Z 字形变换
 * @link https://leetcode-cn.com/problems/zigzag-conversion
 * @description
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class T006_convert {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder result = new StringBuilder();
        int period = numRows + (numRows - 2);// 每个Z字周期，含头不含尾

        for (int i = 0; i < numRows; i ++) {// 按行打印
            for (int j = 0; j < s.length(); j += period) {// 周期数
                int head = i + j;// 每一行对应的周期开头位置
                if (head < s.length()) {
                    result.append(s.charAt(head));
                }
                if (i > 0 && i < numRows - 1 // 除去第一行和最后一行，其他行可能含有两个字符
                && head + (period - 2 * i) < s.length()) {// head + (period - 2 * i)为第二个字符的位置
                    result.append(s.charAt(head + (period - 2 * i)));
                }
            }
        }

        return result.toString();
    }
}
