class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true; 

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];

        // Time: O(n² × L) in the worst case because substring()/hashing can involve the substring length
        // Space: O(n + D), where D is the dictionary storage

    }
}