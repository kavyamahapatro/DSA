class Solution {
    public boolean isUgly(int n) {
        
        // An ugly number is a positive integer whose prime factors contain only 2, 3, and 5. For example, 6 is ugly, while 14 is not because it contains the prime factor 7

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;

        // Time:  O(log n)  Space: O(1)

        // I don't need to find all prime factors. Since the only allowed prime factors are 2, 3, and 5, I can continuously divide by those three values. If the final value is 1, then the number contained no other prime factor
    }
}