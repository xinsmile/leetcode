package com.xin.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈[leetcode] 5. Longest Palindromic Substring(最长的回文子串)〉
 *
 * @author Xingy
 * @FileName: Solution5
 * @create 2018/8/10 16:15
 * @since 1.0.0
 */
public class Solution5 {
    private int lo, maxLen;

    /**
     * 中心扩展法 O(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    /**
     * 头指针+尾指针 判断是否为回数
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        StringBuilder result = new StringBuilder();
        int resultLength = 0;

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length() - resultLength; i++) {

            for (int j = s.lastIndexOf(s.charAt(i)); j>=i+resultLength ; j = s.substring(0, j).lastIndexOf(s.charAt(i))){
                temp = new StringBuilder(s.substring(i, j+1));
                if(temp.toString().equals(temp.reverse().toString())){
                    result = temp;
                    resultLength = temp.length();
                    break;
                }
            }
        }
        return result.toString();
    }
}