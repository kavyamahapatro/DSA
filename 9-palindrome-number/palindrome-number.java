class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes.
        // Numbers ending in 0 cannot be palindromes,
        // except 0 itself.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse only half of the digits
        while (x > reversedHalf) {
            int digit = x % 10;

            reversedHalf = reversedHalf * 10 + digit;

            x /= 10;
        }

        // Even digits: x == reversedHalf
        // Odd digits : x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;

        /* 
        Time  : O(d) = O(log x)
        Space : O(1)
        */
    }
}