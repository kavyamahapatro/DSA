import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // this is generally better than sorting because sorting takes O(n log n) time.

        /*
        Use a HashSet to store each number as you traverse the array.
        If set.add(num) returns false, the number already exists → duplicate found. 
        */

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;

        // O(n) and O(n) - time & space
    }
}