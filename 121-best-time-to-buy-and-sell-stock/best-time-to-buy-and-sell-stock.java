class Solution {
    public int maxProfit(int[] prices) {

        //the key is to track the minimum price seen so far and calculate the profit if we sell today. 

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Lowest buying price so far
            minPrice = Math.min(minPrice, price);

            // Profit if we sell today
            int profit = price - minPrice;

            // Maximum profit so far
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;

        //O(n) and O(1)
    }
}