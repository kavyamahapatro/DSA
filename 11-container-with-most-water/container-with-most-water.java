class Solution {
    public int maxArea(int[] height) {
        
        /* 
        The key idea is Two Pointer
         Start with the widest container and move the pointer with the smaller height
         bcz moving the taller one cannot increase the limiting height
         */

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);

            int area = width * minHeight;
            maxWater = Math.max(maxWater, area);

            // Move the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;

        // time and space - O(n) and O(1)

    }
}