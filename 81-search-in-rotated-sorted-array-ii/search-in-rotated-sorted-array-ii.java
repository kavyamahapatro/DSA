class Solution {
    public boolean search(int[] nums, int target) {
        
        // the main difference from LeetCode 33 is duplicates. Duplicates can make it impossible to determine which half is sorted, so we need an extra case to shrink the search range

        /* 
        Average: O(log n)
        Worst case: O(n)
        Space: O(1)
        The worst case becomes O(n) because an array such as [1,1,1,1,1,1,2,1] can force us to discard only one element at a time
        */

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found target
            if (nums[mid] == target) {
                return true;
            }

            // Duplicates: cannot determine which half is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies in sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                // Target lies in sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;

        /* 
        I use a modified binary search because after rotation, at least one half is always sorted.
        I ll check which half is sorted and see whether the target lies within that range, then discard the other half.
        Because duplicates can make both halves look identical, when nums[left] == nums[mid] == nums[right], I shrink both boundaries
        */
    }
}