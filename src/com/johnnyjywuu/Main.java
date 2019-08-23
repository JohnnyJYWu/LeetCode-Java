package com.johnnyjywuu;

import com.johnnyjywuu.t0_20.T020_isValid;
import com.johnnyjywuu.t21_40.T026_removeDuplicates;
import com.johnnyjywuu.t21_40.T028_strStr;

import java.util.Arrays;

/**
 * @author Created by Johnny Wu on 2019/8/13.
 * @title LeetCode中文网
 * @link https://leetcode-cn.com/problemset/all/
 * @description 测试类
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
//        test0_20();
        test21_40();
    }

    private static void test21_40() {
        T026_removeDuplicates test26 = new T026_removeDuplicates();
//        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
//        int result = test26.removeDuplicates(arr);
//        System.out.println(result);
//        System.out.println(Arrays.toString(arr));

        T028_strStr test28 = new T028_strStr();
        int result = test28.strStr("hello", "ll");
        System.out.println(result);
    }

    private static void test0_20() {
//        T001_twoSum test = new T001_twoSum();
//        int[] result = test.twoSum(new int[]{3, 2, 4}, 6);
//        System.out.println(result);

//        T003_lengthOfLongestSubstring test3 = new T003_lengthOfLongestSubstring();
//        int result = test3.lengthOfLongestSubstring("pwwkew");
//        System.out.println(result);

//        T006_convert test6  = new T006_convert();
//        String result = test6.convert("PAYPALISHIRING", 3);
//        System.out.println(result);

//        T007_reverse test7 = new T007_reverse();
//        int result = test7.reverse(-321);
//        System.out.println(result);

//        T008_myAtoi test8 = new T008_myAtoi();
//        int result = test8.myAtoi("-91283472332");
//        System.out.println(result);

//        T009_isPalindrome test9 = new T009_isPalindrome();
//        boolean result = test9.isPalindrome(1000021);
//        System.out.println(result);

//        T012_intToRoman test12 = new T012_intToRoman();
//        String result = test12.intToRoman(1994);
//        System.out.println(result);

//        T013_romanToInt test13 = new T013_romanToInt();
//        int result = test13.romanToInt("MCMXCIV");
//        System.out.println(result);

//        T014_longestCommonPrefix test14 = new T014_longestCommonPrefix();
//        String result = test14.longestCommonPrefix(new String[] {"flower","flow","flight"});
//        System.out.println(result);

        T020_isValid test20 = new T020_isValid();
        boolean result = test20.isValid("");
        System.out.println(result);
    }
}
