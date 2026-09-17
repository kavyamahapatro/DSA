class Solution {
    public int distributeCandies(int[] candyType) {

        // The sister can receive at most n / 2 candies. Also, she cannot receive more different types than exist in the array - min(number of unique types, n / 2)

        Set<Integer> unique = new HashSet<>();

        for (int candy : candyType) {
            unique.add(candy);
        }

        return Math.min(unique.size(), candyType.length / 2);

        // O(n) and O(n)
    }
}