class Solution {
    public boolean isMatch(String s, String p) {

        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p, memo);
    }

    private boolean dfs(int i, int j, String s, String p, Boolean[][] memo) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean firstMatch = i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = dfs(i, j + 2, s, p, memo) ||
                    (firstMatch && dfs(i + 1, j, s, p, memo));
        } else {
            result = firstMatch && dfs(i + 1, j + 1, s, p, memo);
        }

        return memo[i][j] = result;

        /*
        dfs(i, j) checks whether s[i...] matches p[j...]. If characters match (same or .), move both pointers forward.
        If the next pattern character is *, either skip x* or consume one matching character.
        Memoization stores each (i, j) result to avoid repeated work.
        Time: O(m × n), Space: O(m × n).
        */
    }
}
