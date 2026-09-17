class Solution {
    public int findLHS(int[] nums) {

        // A harmonious subsequence must have max - min == 1

        // count the frequency of every number for every number x, if x+1 exists, then : frequency[x] + frequency[x+1] is a valid harmonious subsequence

        /*
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int answer = 0;

        for (int num : freq.keySet()) {
            if (freq.containsKey(num + 1)) {
                answer = Math.max(answer, freq.get(num) + freq.get(num + 1));
            }
        }

        return answer;

        for this time and space complexity : O(n) and O(n)
        */

        Arrays.sort(nums);

        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                answer = Math.max(answer, right - left + 1);
            }
        }

        return answer;
        
        // O(n log n) because of sorting, so the hashmap version is asymptotically better
    }
}