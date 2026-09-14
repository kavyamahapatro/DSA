class Solution {
    public int minimumDifference(int[] nums, int k) {

        // After sorting, the best k scores will always form a contiguous window, so we check nums[i + k - 1] - nums[i] for every window.

        Arrays.sort(nums); 
        
        int minDiff = Integer.MAX_VALUE; 
        
        for (int i = 0; i <= nums.length - k; i++) { 
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]); 
        } 
        
        return minDiff;

        /*
        Complexity:
        Sorting: O(n log n)
        Sliding window: O(n)
        Overall: O(n log n)
        Extra space: O(log n) due to Java's sorting implementation.

        minDiff = min(minDiff, nums[i + k - 1] - nums[i])
        sliding window formula
        */
    }
}