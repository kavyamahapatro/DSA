class Solution {
    public int fillCups(int[] amount) {
        
        int time = 0;

        while (amount[0] + amount[1] + amount[2] > 0) {
            Arrays.sort(amount);

            amount[2]--;

            if (amount[1] > 0) {
                amount[1]--;
            }

            time++;
        }

        return time;

        /*  Sort → O(1) because there are always only 3 elements Loop runs at most sum(amount) times  Overall: O(sum(amount))    Space: O(1)  */
    }
}