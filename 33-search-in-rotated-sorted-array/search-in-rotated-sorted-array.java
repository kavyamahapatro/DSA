class Solution {
    public int search(int[] nums, int target) {

        // Even though the entire array isn't sorted, at least one half is always sorted

        /*
        At every mid:
        Check nums[mid] == target.
        Determine which half is sorted:
        nums[left] <= nums[mid] → left half is sorted.
        Otherwise → right half is sorted.
        Check whether the target can exist inside that sorted half.
        Eliminate the other half.
        */

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //because of what if element goes out of it's space
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies inside the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                // Target lies inside the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    
        // O(log n) and O(1)

        // Find the sorted half → check whether target belongs there → discard the other half.
    }
}   