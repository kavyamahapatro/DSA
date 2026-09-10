class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;

        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);

            if (i < s.length()) {
                result ^= s.charAt(i);
            }
        }

        return result;
        //O(n) and O(1) - time & space
    }
}