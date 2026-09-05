class Solution {
    public int[] shortestToChar(String s, char c) {
        
        // There are two main approaches: brute force and a two-pass approach. In brute force, for every index I can scan the string to the left and right to find the nearest occurrence of c, which can take O(n²) time. This is not ideal because the same positions are scanned repeatedly. Instead, I make one pass from left to right to calculate the distance from the nearest c on the left, and another pass from right to left for the nearest c on the right. For every index, I take the minimum of these two distances. This reduces the time complexity to O(n) with O(n) space for the answer array. 

        int n = s.length();
        int[] ans = new int[n];

        // Left to right
        int dist = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                dist = 0;
            } else {
                dist++;
            }
            ans[i] = dist;
        }

        // Right to left
        dist = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                dist = 0;
            } else {
                dist++;
            }
            ans[i] = Math.min(ans[i], dist);
        }

        return ans;

    }
}