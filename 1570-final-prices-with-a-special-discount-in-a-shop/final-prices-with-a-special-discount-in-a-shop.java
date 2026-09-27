class Solution {
    public int[] finalPrices(int[] prices) {
        
        // I need the first element on the right that is smaller or equal. I maintain a monotonic increasing stack of indices. When the current price is small enough, it becomes the discount for all larger prices popped from the stack.

        java.util.ArrayDeque<Integer> st = new java.util.ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i])
                prices[st.pop()] -= prices[i];

            st.push(i);
        }
        return prices;

        // Time: O(n) | Space: O(n) 
    }
}