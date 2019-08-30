package com.johnnyjywuu.t21_40;

/**
 * @author Created by Johnny Wu on 2019/8/23.
 * @title 28. 实现 strStr()
 * @link https://leetcode-cn.com/problems/implement-strstr
 * @description
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class T028_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (needle.length() == 0) return 0; //needle长度为0时要求返回0
        if (haystack.length() < needle.length()) return -1; //haystack长度 < needle长度，要求返-1

        int start = 0, end = needle.length() - 1; //以needle长度为区间，在haystack中移动该区间进行查找

        while (end < haystack.length()) {
            if (haystack.substring(start, end + 1).equals(needle)) {
                return start;
            }
            start ++;
            end ++;
        }

        return -1;
    }
}
