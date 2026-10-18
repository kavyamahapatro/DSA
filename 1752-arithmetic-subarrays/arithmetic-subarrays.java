import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>();

        for (int q = 0; q < l.length; q++) {
            int left = l[q];
            int right = r[q];

            int[] arr = Arrays.copyOfRange(
                nums, left, right + 1
            );

            Arrays.sort(arr);

            int diff = arr[1] - arr[0];
            boolean isArithmetic = true;

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }

            result.add(isArithmetic);
        }

        return result;
    }
}

/*
 Time: 

O(m⋅klogk), where m is the number of queries and 
k is the maximum subarray length

Extra space: 
O(k) per query

*/