package com.xin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈[leetcode] 6. ZigZag Conversion(ZigZag转换)〉
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author Xingy
 * @FileName: Solution6
 * @create 2018/8/10 21:49
 * @since 1.0.0
 */
public class Solution6 {
    /**
     * 分组： numRows = 3，6个一组,groupNum = 6；numRows = 4，8个一组...........
     * 每一行的数均为 (字符串下标 +/- 行数) % groupNum = 0 的数
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int groupNum = 2 * (numRows - 1);
        for(int i=0; i< numRows; i++) {
            for (int j=0; j< s.length(); j++) {
                if ((j - i) % groupNum == 0 ||
                        (j + i) % groupNum == 0) {
                    res.append(s.charAt(j));
                }
            }
        }
        System.err.println("res==============" + res);
        return res.toString();
    }
}