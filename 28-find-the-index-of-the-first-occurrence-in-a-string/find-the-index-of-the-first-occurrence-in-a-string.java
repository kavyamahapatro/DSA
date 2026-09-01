class Solution {
    public int strStr(String haystack, String needle) {

        /* 
        The straightforward approach is to start from every possible index in the haystack and compare the needle character by character. This can take O(n × m), where n is the haystack length and m is the needle length.
        The better approach is KMP. KMP preprocesses the pattern and uses information about previously matched characters, so when a mismatch happens, we don't start comparing from scratch. This reduces the complexity to O(n + m).
        So I'm choosing KMP because it avoids repeated comparisons and scales better for large strings.
        */

        int[] lps = buildLPS(needle);

        int i = 0; // haystack pointer
        int j = 0; // needle pointer

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;

        /* 
        Optimal approach: KMP
        The important idea: "ababaca"
        If we've already matched: "abab"
        and the next character doesn't match, we don't necessarily need to go back to the beginning.
        KMP tells us how much of the previous match can still be useful.
        
        
        Approach	Time	    Space
       Brute force	O(n × m)	O(1)
          KMP	    O(n + m)	O(m)
        */
    }
}