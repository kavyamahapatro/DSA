class Solution {
    public String addBinary(String a, String b) {
        
        /*
        We need to add two binary strings. I don't want to convert them to integers because the strings can be larger than the range of Java's integer types. Instead, I'll simulate binary addition from right to left, exactly like normal addition, keeping a carry
        Time:  O(max(n, m))
        Space: O(max(n, m))
        */
        
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();

        // If n = a.length() and m = b.length():

        
        // I'm avoiding numeric conversion because the input is represented as strings specifically to allow numbers larger than primitive integer types. Simulating binary addition gives us linear time and avoids overflow
    }
}