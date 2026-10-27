class Solution {
    public int countPrimes(int n) {
 
        boolean[] isPrime = new boolean[n];
        java.util.Arrays.fill(isPrime, true);

        if (n <= 2) return 0;

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}

/*
Create a boolean array isPrime and initially mark every number as prime.

Mark 0 and 1 as non-prime because they are not prime numbers.

Iterate from 2 while i * i < n; if i is prime, mark its multiples as non-prime, starting from i * i.

Count all the numbers that remain marked as prime and return the count.

Time Complexity:  O(nloglogn). 
Space Complexity:  O(n), for the boolean array.

 */