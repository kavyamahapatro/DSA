class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;

        // Total sum
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

        // O(n) and O(1) - extra space idea is rightsum = totalsum - leftsum - nums[i] so we only need one pass after calc the total 
    }
}