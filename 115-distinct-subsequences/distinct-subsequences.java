class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}

/* 

dp[j] stores the number of ways to form the first j characters of t using the characters processed from s.

Initialize dp[0] = 1, because there is exactly one way to form an empty subsequence: choose nothing.

When characters match, add dp[j - 1] to dp[j].

Iterate j backward to avoid using updated values from the current iteration.

Return dp[n].

O(m x n) and O(n)

Here, 
m is the length of s and 
n is the length of t.

*/