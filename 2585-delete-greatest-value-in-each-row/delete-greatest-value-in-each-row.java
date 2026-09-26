import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {

        // Sort every row
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int answer = 0;

        // Start from the largest elements
        for (int col = grid[0].length - 1; col >= 0; col--) {

            int max = 0;

            // Find the largest value in this column
            for (int row = 0; row < grid.length; row++) {
                max = Math.max(max, grid[row][col]);
            }

            answer += max;
        }

        return answer;
    }
}       

// In one sentence: Sort every row, then compare the elements column-by-column from right to left, adding the biggest one each time.

// Time Complexity: O(m × n log n)
// Extra Space: O(1)