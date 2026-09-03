class Solution {
    public boolean isHappy(int n) {
        // The key observation is that repeatedly replacing a number with the sum of squared digits either reaches 1 or gets stuck in a cycle.I’ll use Floyd’s cycle detection with a slow and fast pointer, avoiding extra space for a HashSet. The slow pointer moves one transformation at a time, while the fast pointer moves two. If they meet at 1, the number is happy; otherwise, a cycle exists.

        int slow = n;
        int fast = n;

        do {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int nextNumber(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;

        // O(log n) per transformation, effectively constant for the given integer range and space compl. O(1) 
 
    }
}