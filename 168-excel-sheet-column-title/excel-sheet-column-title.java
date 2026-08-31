class Solution {
    public String convertToTitle(int columnNumber) {
        
        /* 
        this is rev of col num
        1 -> A, 2 -> B,.........52 -> AZ, 53 -> BA

        2 approaches - recursion, normal base conversion

        1 -> we can recursively cal the char from right to left
        for eg, 28 = 28 -> B remainder 2
        1 -> A

        giving res as AB

        this works but rec isnt necessary here
        we can solve it iteratively with constant auxiliary space

        2 -> at first we mnight think
        remainder = n % 26 but small catch

        excel col are a = 1 z = 26 tak
        there is no 0 representation
        normal base 26 has :
        0 -> 0 1-> 1,......... 25

        so we need to adjust the first number
        key = before taking the rem

        n--;
        then rem = n % 26 and 'A' + rem;
        then it gives us the correct char

        eg : n = 28 -> subtract 1 -> n = 27
        rem = 27 % 26 = 1
        char 'A' + 1 = 'B'
        now n = 27/26 = 1 
        again n = 1-1 = 0
        rem 0% 26 = 0
        char 'A' 
        we generated, BA
        but its frim right to left so rev it to AB
        therefore 28 -> AB

        time & space = O(n) both 
        for the op str - O(n)
        algo itself uses O(1) auxiliary space apart from the req op

        */

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            char c = (char) ('A' + remainder);

            sb.append(c);

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}