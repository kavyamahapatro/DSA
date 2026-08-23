class Solution {
    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (rev > 214748364 || 
                (rev == 214748364 && digit > 7)) {
                return 0;
            }

            if (rev < -214748364 || 
                (rev == -214748364 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;

        /* 
        Time  : O(log |x|)
        Space : O(1)
        */

        /* 
        The algorithm repeatedly takes the last digit of x, adds it to the end of rev, removes that digit from x, and checks beforehand whether adding the digit would cause integer overflow.
        */
        
    }
}