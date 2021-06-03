package com.specflare.algohut.leetcode.dp;

// Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParen {
    // DP solution, dp[i] contains the longest valid paren ending at position i.
    public static int longestValidParentheses_v2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
