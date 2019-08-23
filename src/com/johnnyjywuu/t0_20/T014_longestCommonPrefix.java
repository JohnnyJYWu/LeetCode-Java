package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/23.
 * @title 14. 最长公共前缀
 * @link https://leetcode-cn.com/problems/longest-common-prefix
 * @description
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */

public class T014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length <= 0) return result.toString();

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int index = 0;
        while (index < minLength) {
            char ch = strs[0].charAt(index);
            for (String str : strs) {
                if (str.charAt(index) != ch) {
                    return result.toString();
                }
            }
            result.append(ch);
            index ++;
        }

        return result.toString();
    }
}
