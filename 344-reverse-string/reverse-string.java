class Solution {
    public void reverseString(char[] s) {
        
        // This problem explicitly requires modifying the character array in-place with O(1) extra memory, so the ideal solution is the classic two-pointer swap. 

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;

            // Time: O(n) and Space: O(1)This is the optimal possible solution because every character potentially needs to be moved.
        }
    }
}