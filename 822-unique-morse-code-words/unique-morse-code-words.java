import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        // Each letter has a fixed Morse representation, and we need the number of different transformed strings. A HashSet<String> automatically removes duplicates, so we simply transform every word and insert it

        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        Set<String> unique = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }

            unique.add(sb.toString());
        }

        return unique.size();

        /* 
        morse[c - 'a'] directly maps each lowercase letter to its Morse code in O(1).StringBuilder efficiently constructs the transformation without repeatedly creating strings. HashSet keeps only unique transformations, which is exactly what the problem asks for. If N is total characters across all words, Time: O(N) average; Space: O(N) for the transformed strings. 
        */
    }
}
