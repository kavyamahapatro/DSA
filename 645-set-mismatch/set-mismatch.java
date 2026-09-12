class Solution {
    public int[] findErrorNums(int[] nums) {

        // Best: O(n) time, O(1) extra space

        // This is better than sorting because sorting would take O(n log n).

        int duplicate = -1;
        int missing = -1;

        // Find duplicate
        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[index] = -nums[index];
            }
        }

        // Find missing
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}