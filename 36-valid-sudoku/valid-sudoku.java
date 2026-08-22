class Solution {
    public boolean isValidSudoku(char[][] board) {

        /*
        Every row must have unique digits.
        Every column must have unique digits.
        Every 3 × 3 box must have unique digits.
        */
        
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                if (set.contains(current)) {
                    return false;
                }

                set.add(current);
            }
        }

    
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                if (set.contains(current)) {
                    return false;
                }

                set.add(current);
            }
        }

        
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                HashSet<Character> set = new HashSet<>();

                for (int row = boxRow; row < boxRow + 3; row++) {
                    for (int col = boxCol; col < boxCol + 3; col++) {

                        char current = board[row][col];

                        if (current == '.') {
                            continue;
                        }

                        if (set.contains(current)) {
                            return false;
                        }

                        set.add(current);
                    }
                }
            }
        }

        return true;

        // time & space both are O(1)
    }
}