package com.specflare.algohut.leetcode.dp;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which
 * has exactly n nodes of unique values from 1 to n.
 *
 * Given n=5, we iterate for i = 1 to 5, the left subtree will contain nodes 1..i-1, right subtree witll contain nodes
 * i+1..n. so the total number of combinations is numLeftSubtrees * numRightSubtrees.
 * This is also the n-th Catalan number.
 */

public class UniqueBSTs {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = dp[i - 1] * 2;
            for (int j = 2; j < i; j++)
            {
                int left = j - 1; // from 0 to i-1
                int right = i - j;
                sum += dp[left] * dp[right];
            }

            dp[i] = sum;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBSTs ub = new UniqueBSTs();
        System.out.println(ub.numTrees(5));
    }
}
