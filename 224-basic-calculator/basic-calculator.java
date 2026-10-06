class Solution {
    public int calculate(String s) {

        int result = 0;
        int number = 0;
        int sign = 1;

        int[] stack = new int[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } 

            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 

            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 

            else if (c == '(') {
                stack[++top] = result;
                stack[++top] = sign;

                result = 0;
                sign = 1;
            } 

            else if (c == ')') {
                result += sign * number;
                number = 0;

                int previousSign = stack[top--];
                int previousResult = stack[top--];

                result = previousResult + previousSign * result;
            }
        }

        return result + sign * number;
    }
}

/* 
Time: O(n) — every character is processed once
Space: O(n) worst case for nested parentheses
*/