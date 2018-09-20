/**   
 * Copyright © 2018 
 * 
 * @Package: com.xin.leetcode.algorithms 
 * @author: Xingy   
 * @date: 2018年8月22日 下午7:37:26 
 */
package com.xin.leetcode.algorithms;

/** 
 * @ClassName: Solution9 
 * @Description: Palindrome Number (回文数)
 * @author: Xingy
 * @date: 2018年8月22日 下午7:37:26  
 */
public class Solution9Reverse {
	
	public boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE
        		|| x < 0) {
        	return isPalindrome;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = (x + "").length();
        for (int i = 0; i < length; i++) {
        	stringBuilder.append((x + "").substring(length-i-1, length-i));
        }
        if ((x + "").equals(stringBuilder.toString())) {
        	isPalindrome = true;
        }
        return isPalindrome;
    }
}
