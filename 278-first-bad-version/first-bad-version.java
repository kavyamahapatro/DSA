/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid could be the first bad version
                right = mid;
            } else {
                // First bad version must be after mid
                left = mid + 1;
            }
        }

        return left;

        /*
        All versions before the first bad version are good, and all versions from the first bad version onward are bad
        So I use binary search to find the first true value
        If mid is bad, it could be the answer, so I keep mid by moving right to mid
        Otherwise, I move left to mid + 1. The complexity is O(log n) time and O(1) space
        */
    }
}