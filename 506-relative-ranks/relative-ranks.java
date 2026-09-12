class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // Store indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on scores descending
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

        String[] ans = new String[n];

        for (int rank = 0; rank < n; rank++) {
            int index = indices[rank];

            if (rank == 0) {
                ans[index] = "Gold Medal";
            } else if (rank == 1) {
                ans[index] = "Silver Medal";
            } else if (rank == 2) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(rank + 1);
            }
        }

        return ans;

        /* 
        Complexity
        Time: O(n log n)
        Space: O(n)
        Key idea: Sort indices, not the actual scores, so we can put the rank back into the original positions
        */
        
    }
}