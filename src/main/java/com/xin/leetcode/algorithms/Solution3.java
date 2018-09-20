package com.xin.leetcode.algorithms;

import java.util.*;

/**
 * 〈一句话功能简述〉
 * 〈[leetcode] 3 Longest Substring Without Repeating Characters 〉
 *
 * @author Xingy
 * @FileName: Solution3
 * @create 2018/8/9 23:34
 * @since 1.0.0
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null || "".equals(s)) {
            return 0;
        }
        List<String> list = new ArrayList<String>();
        for (int i = 1; i<= s.length(); i++) {
            if (!list.contains(s.substring(i-1,i))) {
                list.add(s.substring(i-1,i));
            } else {
                maxLength = list.size() > maxLength ? list.size() : maxLength;
                int index = list.indexOf(s.substring(i-1,i));
                for(int x=0; x<=index; x++) {
                    list.remove(0);
                }
                list.add(s.substring(i-1,i));
            }
        }
        maxLength = list.size() > maxLength ? list.size() : maxLength;
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i=0; i<s.length(); i++) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i-left);
        }
        return res;
    }

    /**
     * left++ 下一个不重复子串的起点在字符串中的下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }
}