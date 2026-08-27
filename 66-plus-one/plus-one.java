class Solution {
    public int[] plusOne(int[] digits) {

        // The idea is to start from the last digit. If it is 9, make it 0 and carry 1 to the left. Otherwise, increment it and return.

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // If all digits were 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;

        // Time: O(n) and Space: O(n) in the all-9 case.
        
    }
}