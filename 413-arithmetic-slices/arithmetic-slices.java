class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int current = 0;
        int total = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1]
                    == nums[i - 1] - nums[i - 2]) {

                current++;
                total += current;
            } else {
                current = 0;
            }
        }

        return total;
    }
}

// O(n) and O(1) - time and space complexity