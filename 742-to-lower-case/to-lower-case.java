class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }

            result.append(c);
        }

        return result.toString();

        //     simple : return s.toLowerCase();
        // Complexity: O(n) time and O(n) space
    }
}