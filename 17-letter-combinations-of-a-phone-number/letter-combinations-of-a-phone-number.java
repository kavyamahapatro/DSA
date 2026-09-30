class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, phone, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
        int index,
        String digits,
        String[] phone,
        StringBuilder current,
        List<String> result
    ) {

        // create one complete combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters to current digit
        String letters = phone[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            // Choose
            current.append(ch);

            // Explore
            backtrack(index + 1, digits, phone, current, result);

            // Undo 
            current.deleteCharAt(current.length() - 1);
        }
    }
}

// Time: O(4^n * n)

// Space: O(n) recursion stack, excluding the output