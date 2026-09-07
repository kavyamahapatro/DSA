class Solution {
    public int search(int[] nums, int target) {
        
        /* 
        Since the array is sorted, I use binary search with left and right boundaries
        I compare the middle element with the target and eliminate half of the search space each time
        If the middle value is smaller, I search the right half; otherwise, I search the left half
        This gives O(log n) time and O(1) space
        */

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}