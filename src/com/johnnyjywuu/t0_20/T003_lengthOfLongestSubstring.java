package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/14.
 * @title 3. 无重复字符的最长子串
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * @description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class T003_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {// 滑动窗口
        int result = 0;
        int[] index = new int[256];// 计数，以每个char字符对应ASCII码作为index数组位置+1，记录字符在字符串s中的位置+1（即该字符的后一个位置）
        int flag = 0;// flag用于标记发生重复字符在字符串中后一个字符的位置，如abcdeafg，遍历到第二个a时，flag标记第一个a后面的b的位置
        // 发生重复时，flag可作为滑动窗口的头部重新进行长度计算
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            flag = Math.max(flag, index[ch]);// index数组初始化全部为0，若发生重复，重复字符对应的位置不为0，而是该字符在字符串中【上一次出现位置的后一个位置】的值
            result = Math.max(result, i - flag + 1);
            index[ch] = i + 1;
        }

        return result;
    }
}
