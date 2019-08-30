package com.johnnyjywuu;

import com.johnnyjywuu.model.ListNode;
import com.johnnyjywuu.model.TreeNode;
import com.johnnyjywuu.t101_120.T102_levelOrder;
import com.johnnyjywuu.t101_120.T103_zigzagLevelOrder;
import com.johnnyjywuu.t81_100.*;

import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/13.
 * @title LeetCode中文网
 * @link https://leetcode-cn.com/problemset/all/
 * @description 测试类
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        test0_20();
        test21_40();
        test41_60();
        test61_80();
        test81_100();
        test101_120();
    }

    private static void test101_120() {
        T102_levelOrder test102 = new T102_levelOrder();
        List<List<Integer>> result102 = test102.levelOrder(Utils.buildTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}));
        System.out.println(result102.toString());

        T103_zigzagLevelOrder test103 = new T103_zigzagLevelOrder();
        List<List<Integer>> result103 = test103.zigzagLevelOrder(Utils.buildTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}));
        System.out.println(result103.toString());

    }

    private static void test81_100() {
//        T092_reverseBetween test92 = new T092_reverseBetween();
//        ListNode result = test92.reverseBetween(Utils.buildListNode(new int[] {1, 2, 3, 4, 5}), 2, 4);
//        System.out.println(result.toString());


    }

    private static void test61_80() {

    }

    private static void test41_60() {
//        T045_jump test45 = new T045_jump();
//        int result45 = test45.jump(new int[] {2, 2, 1, 1, 4});
//        System.out.println(result45);

//        T046_permute test46 = new T046_permute();
//        List<List<Integer>> result46 = test46.permute(new int[] {1, 2, 3});

//        T047_permuteUnique test47 = new T047_permuteUnique();
//        List<List<Integer>> result47 = test47.permuteUnique(new int[] {1, 1, 2});

//        T050_myPow test50 = new T050_myPow();
//        double result50 = test50.myPow(2.00000, -2);
//        System.out.println(result50);

//        T051_solveNQueens test51 = new T051_solveNQueens();
//        List<List<String>> result51 = test51.solveNQueens(4);
//
//        System.out.println();
    }

    private static void test21_40() {
//        T022_generateParenthesis test22 = new T022_generateParenthesis();
//        List<String> result22 = test22.generateParenthesis(3);
//        System.out.println(Arrays.toString(result22.toArray()));

//        T025_reverseKGroup test25 = new T025_reverseKGroup();
//        ListNode result25 = test25.reverseKGroup(Utils.buildListNode(new int[] {1, 2}), 2);
//        System.out.println(result25.toString());

//        T026_removeDuplicates test26 = new T026_removeDuplicates();
//        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
//        int result26 = test26.removeDuplicates(arr);
//        System.out.println(result26);
//        System.out.println(Arrays.toString(arr));

//        T028_strStr test28 = new T028_strStr();
//        int result28 = test28.strStr("hello", "ll");
//        System.out.println(result28);
    }

    private static void test0_20() {
//        T001_twoSum test = new T001_twoSum();
//        int[] result1 = test.twoSum(new int[]{3, 2, 4}, 6);
//        System.out.println(result1);

//        T003_lengthOfLongestSubstring test3 = new T003_lengthOfLongestSubstring();
//        int result3 = test3.lengthOfLongestSubstring("pwwkew");
//        System.out.println(result3);

//        T006_convert test6  = new T006_convert();
//        String result6 = test6.convert("PAYPALISHIRING", 3);
//        System.out.println(result6);

//        T007_reverse test7 = new T007_reverse();
//        int result7 = test7.reverse(-321);
//        System.out.println(result7);

//        T008_myAtoi test8 = new T008_myAtoi();
//        int result8 = test8.myAtoi("-91283472332");
//        System.out.println(result8);

//        T009_isPalindrome test9 = new T009_isPalindrome();
//        boolean result9 = test9.isPalindrome(1000021);
//        System.out.println(result9);

//        T012_intToRoman test12 = new T012_intToRoman();
//        String result12 = test12.intToRoman(1994);
//        System.out.println(result12);

//        T013_romanToInt test13 = new T013_romanToInt();
//        int result13 = test13.romanToInt("MCMXCIV");
//        System.out.println(result13);

//        T014_longestCommonPrefix test14 = new T014_longestCommonPrefix();
//        String result14 = test14.longestCommonPrefix(new String[] {"flower","flow","flight"});
//        System.out.println(result14);

//        T019_removeNthFromEnd test19 = new T019_removeNthFromEnd();
//        ListNode result19 = test19.removeNthFromEnd(Utils.buildListNode(new int[]{1, 2}), 2);
//        if (result19 != null) System.out.println(result19.toString());

//        T020_isValid test20 = new T020_isValid();
//        boolean result20 = test20.isValid("");
//        System.out.println(result20);
    }
}
