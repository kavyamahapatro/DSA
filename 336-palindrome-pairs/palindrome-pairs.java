import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();

            for (int j = 0; j <= n; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                String revLeft =
                    new StringBuilder(left).reverse().toString();

                String revRight =
                    new StringBuilder(right).reverse().toString();

                // Case 1: left is a palindrome
                if (isPalindrome(left)) {
                    if (map.containsKey(revRight)
                            && map.get(revRight) != i) {
                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }

                // Case 2: right is a palindrome
                // j < n avoids duplicate pairs
                if (j < n && isPalindrome(right)) {
                    if (map.containsKey(revLeft)
                            && map.get(revLeft) != i) {
                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

// O(nk^2) where n is the number of words and k is the maximum word length.
// O(S) for the hash map, plus the output, where S is the total number of characters.