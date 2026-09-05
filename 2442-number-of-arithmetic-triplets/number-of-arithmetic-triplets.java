class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        /*
        There are three approaches: 
        brute force with three loops, HashSet, and two pointers.
         In brute force, I try every possible (i, j, k) triplet and check whether the two differences equal diff, which takes O(n³) time. 
         That is unnecessary because the array is strictly increasing, so I can use the relationship x, x + diff, and x + 2 * diff. 
         With a HashSet, I can check whether the next two required values exist in O(1) average time, giving O(n) time and O(n) space. 
         Since the values are bounded in this particular problem, I can also use a boolean array for the same linear-time idea. 
        */

        boolean[] present = new boolean[201];

        for (int num : nums) {
            present[num] = true;
        }

        int count = 0;

        for (int num : nums) {
            if (num + diff <= 200 &&
                num + 2 * diff <= 200 &&
                present[num + diff] &&
                present[num + 2 * diff]) {

                count++;
            }
        }

        return count;

        // This particular problem has nums[i] <= 200, so the boolean-array solution is especially clean.
    }
}