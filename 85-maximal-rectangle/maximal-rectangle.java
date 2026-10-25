class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1];
        int maxArea = 0;
        int[] stack = new int[cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = (matrix[i][j] == '1')
                        ? heights[j] + 1
                        : 0;
            }

            int top = -1;

            for (int j = 0; j <= cols; j++) {
                int currentHeight = (j == cols) ? 0 : heights[j];

                while (top >= 0 &&
                       heights[stack[top]] > currentHeight) {
                    int height = heights[stack[top--]];

                    int width = (top == -1)
                            ? j
                            : j - stack[top] - 1;

                    maxArea = Math.max(maxArea, height * width);
                }

                stack[++top] = j;
            }
        }

        return maxArea;
    }
}

// O(m x n) and O(n) - time & space

/* 

Build histogram heights: For each row, increment heights[j] if the cell is '1'; otherwise reset it to 0.

Maintain a monotonic stack: Store column indices in increasing order of their bar heights.

Calculate rectangle areas: When a shorter bar appears, pop taller bars and calculate their maximum possible areas.

Use a sentinel: The extra column at index cols has height 0, forcing the remaining bars to be processed.

For each popped bar:
area=height×width

The width is j if the stack is empty after popping, or j - stack[top] - 1 otherwise.

This is optimal because each histogram index is pushed and popped at most once per row.

*/