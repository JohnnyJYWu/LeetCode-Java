package com.johnnyjywuu.t101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 118. 杨辉三角
 * @link https://leetcode-cn.com/problems/pascals-triangle
 * @description
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class T118_generate {
    public List<List<Integer>> generate(int numRows) { //动态规划
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;

        result.add(new ArrayList<>());
        result.get(0).add(1); //顶部的1

        for (int i = 1; i < numRows; i ++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = result.get(i - 1); //上一行
            //添加每行第一个1
            row.add(1);
            //添加中间部分，值为 上一行对应的前一个数 加 上一行对应的当前数
            for (int j = 1; j < i; j ++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            //添加每一行最后一个1
            row.add(1);
            result.add(row);
        }

        return result;
    }
}
