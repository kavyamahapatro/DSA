class Solution {
    public String multiply(String num1, String num2) {
        
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int product = a * b;
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) {
            if (sb.length() == 0 && digit == 0) {
                continue;
            }
            sb.append(digit);
        }

        return sb.toString();
    }
}

/*

Each digit of num1 is multiplied with each digit of num2, just like manual multiplication

The int[] stores each digit at its correct position and handles carries

Time complexity is O(m × n) and space complexity is O(m + n)

*/