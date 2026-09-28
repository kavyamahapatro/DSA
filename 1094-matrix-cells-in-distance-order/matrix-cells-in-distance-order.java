class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        // O(rows x cols) for creating cells, sorting O((rows x cols) log(rows x cols))
        
        int[][] cells = new int[rows * cols][2];

        int index = 0;

        // Store every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[index++] = new int[]{r, c};
            }
        }

        // Sort by Manhattan distance
        Arrays.sort(cells, (a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return Integer.compare(distA, distB);
        });

        return cells;

        // Generate all coordinates → calculate Manhattan distance → sort.

    }
}