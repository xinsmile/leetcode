package com.xin.leetcode.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 * 〈8. String to Integer (atoi) 字符串到整数〉
 *
 *
 * @author Xingy
 * @FileName: Solution8
 * @create 2018/8/11 21:59
 * @since 1.0.0
 */
public class Solution8 {

    public int myAtoi(String str) {
        int res = 0;
        if (str == null) {
            return  0;
        }
        //去除行首空格
        str = str.replaceAll("^\\s*", "");
        if ("".equals(str)) {
            return  0;
        }
        //正则匹配数字字符串
        Pattern pattern = Pattern.compile("^[-+0-9]\\d*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str = matcher.group(0);
        } else {
            return 0;
        }
        String firstChat = str.substring(0, 1);
        String s = str.replace("+", "")
                .replace("-", "");
        //去除开头为0的数字
        while (s.length() > 0 && s.charAt(0) == '0') {
           s = s.substring(1, s.length());
        }
        if ("".equals(s)) {
            return 0;
        }
        //防止数字超过long范围
        if (s.length() > (Integer.MAX_VALUE + "").length()) {
            if ("-".equals(firstChat)) {
                res = Integer.MIN_VALUE;
            } else  {
                res = Integer.MAX_VALUE;
            }
        } else {
            //正负问题
            long num = Long.parseLong(s);
            if (!"-".equals(firstChat) && num >= Integer.MAX_VALUE){
                res = Integer.MAX_VALUE;
            } else if ("-".equals(firstChat) && -num <= Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            } else {
                res = Integer.parseInt(str);
            }
        }
        System.out.println(res);
        return res;
    }
}