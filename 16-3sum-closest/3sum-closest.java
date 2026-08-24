import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        /* 
        Use sorting + two pointers
         Fix one number, 
         then use left and right to find the pair 
         whose sum gets closest to the remaining target. 
        */

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Exact match
                if (sum == target) {
                    return sum;
                }

                // Update closest answer
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;

        /*
        Complexity:
        Sorting: O(n log n)
        Two-pointer search: O(n²)
        Overall: O(n²)
        Extra space: O(1) apart from Java's sorting implementation
        
        Container With Most Water: Two Pointers
        3Sum Closest: Sort + Two Pointers
        When using two pointers:
        If current sum is too small → left++
        If current sum is too large → right-- 
        
        */

    }
}