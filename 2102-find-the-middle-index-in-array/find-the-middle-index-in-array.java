class Solution {
    public int findMiddleIndex(int[] nums) {
        // Optimal: O(n) time, O(1) extra space.
        int total = 0; 
        for (int num : nums) { 
            total += num; 
        } 
        int leftSum = 0; 
        for (int i = 0; i < nums.length; i++) {
             int rightSum = total - leftSum - nums[i]; 
             if (leftSum == rightSum) { 
                return i; 
                } 
            leftSum += nums[i]; 
            } 
        return -1;
    }
}