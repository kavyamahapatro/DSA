
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        /* 
        required HashMap: Stores the required frequency of each word
        offset loop: Checks every possible alignment from 0 to wordLen - 1
        right pointer: Reads the string in chunks of wordLen characters
        Invalid word: Clears the current window and starts again after that word
        Excess word: Moves left forward until word frequencies satisfy the requirements
        Valid window: When the window contains exactly words.length words, records the starting index
        */

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (!required.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > required.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }

        return result;

        // Time: (O(n x L) expected, where n is s.length() and L is the word length, assuming average constant-time HashMap operations and bounded word lengths
        // Space: (O(m), where m is the number of distinct words, for the frequency maps
    }
}
