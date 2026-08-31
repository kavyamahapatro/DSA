class Solution {
    public boolean isValid(String s) {
        /* 
        We could repeatedlty remove valid pairs, if the final string is empty, its valid, this approach repeatedly modifies/searches the string can result in O(n2) in worst case so lite
        next approach is LIFO
        whenever we see an opening backet, we push it onto a stack, whenever we see a closing bracket, we check whether it matches the most recently opened bracket, stack empty matlab valid- best optimal approach is this
        time and space complexity is O(n)
        whenever we see correct order, nested, matching, most recently opened - STACK
         */

                 Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening bracket
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Closing bracket
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}