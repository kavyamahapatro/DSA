
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int rounds = minutesToTest / minutesToDie;
        int states = rounds + 1;

        int pigs = 0;
        long possible = 1;

        while (possible < buckets) {
            possible *= states;
            pigs++;
        }

        return pigs;
    }
}

//O(log base states​ then (buckets)), space O(1)