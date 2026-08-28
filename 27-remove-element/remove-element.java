class Solution {
    public int removeElement(int[] nums, int val) {

        /* 
        k keeps track of where to place the next valid element.
        If nums[i] != val, copy it to nums[k]. Increment k. Finally, return k.*/

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

        // O(n) and O(1)
    }
}