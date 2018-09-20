/**   
 * Copyright © 2018 
 * 
 * @Package: com.xin.leetcode.algorithms 
 * @author: Xingy   
 * @date: 2018年8月22日 下午11:21:33 
 */
package com.xin.leetcode.algorithms;

/** 
 * @ClassName: Solution10 
 * @Description: 10. Regular Expression Matching (正则表达式匹配)
 * @author: Xingy
 * @date: 2018年8月22日 下午11:21:33  
 */
enum Result {
    TRUE, FALSE
}

public class Solution10 {
	
	Result[][] memo;

    public boolean isMatch1(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
	
	/**
	 * 
	* @Title: isMatch 
	* @Description: 递归算法 
	* @param s
	* @param p
	* @return boolean
	* @author Xingy
	* @date 2018年8月23日上午9:20:43
	 */
	public boolean isMatch(String s, String p) {
		System.out.println("s= " + s +" , p= " + p);
        if (p.isEmpty()) {
        	return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && 
        		(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
        	return (isMatch(s, p.substring(2))
        			|| (first_match && isMatch(s.substring(1), p)));
        } else {
        	return first_match && (isMatch(s.substring(1), p.substring(1)));
        }
    }
	
	
}
