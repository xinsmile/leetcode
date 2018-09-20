package com.xin.leetcode.algorithms;

/**
 * 〈一句话功能简述〉
 * 〈[leetcode] 7. Reverse Integer〉
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * @author Xingy
 * @FileName: Solution7Reverse
 * @create 2018/8/10 22:58
 * @since 1.0.0
 */
public class Solution7Reverse {
    public int reverse(int x) {
        long res = 0;
        StringBuilder rev = new StringBuilder();
        String s = (x + "").replace("-","");
        for (int i = s.length() - 1; i >= 0; i--){
            rev.append(s.charAt(i));
        }
        res = Long.parseLong(rev.toString());
        if (x < 0) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}