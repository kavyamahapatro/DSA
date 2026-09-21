class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }

        return stack.toString();


        // Time: O(n + m) 
        // Space: O(n + m)

        /* class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);

            if (i < 0 && j < 0) {
                return true;
            }

            if (i < 0 || j < 0) {
                return false;
            }

            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    private int nextValidIndex(String s, int i) {
        int skip = 0;

        while (i >= 0) {
            if (s.charAt(i) == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                break;
            }

            i--;
        }

        return i;
    }
}      */

    }
}