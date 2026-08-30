class Solution {
    public List<String> summaryRanges(int[] nums) {

        // Summary Ranges, since the array is already sorted and contains unique integers, we can scan it once and group consecutive numbers into ranges.
        
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                result.add(String.valueOf(start));
            } 

            else {
                result.add(start + "->" + end);
            }

            i++;
        }

        return result;

        /* Time: O(n)
        Space: O(n) for the output list
        Extra space: O(1)
        */
        
    }
}