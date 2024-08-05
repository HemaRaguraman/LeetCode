class Solution {
    public int myAtoi(String s) {
   if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0, sign = 1, total = 0;
        int length = s.length();

        // Ignore leading whitespaces
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // Check for optional sign
        if (index < length && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert digits to integer
        while (index < length) {
            char c = s.charAt(index);

            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // Check for overflow and underflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }

}