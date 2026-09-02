class Solution {
    public int firstUniqChar(String s) {
        
        // Use two passes: Count how many times each character appears. Scan the string from left to right and return the first character whose count is 1.

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;

        // time & space - O(n) and O(1) bc freq array has only 26 positions

        // Don't repeatedly call indexOf()/lastIndexOf() for every character; that can become O(n²). The frequency-counting approach gives you a clean O(n) solution.
    }
}