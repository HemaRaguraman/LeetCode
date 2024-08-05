class Solution {
    public String addBinary(String a, String b) {
       StringBuilder result = new StringBuilder();
        int carry = 0;

        int aLength = a.length();
        int bLength = b.length();

        for (int i = 0; i < Math.max(aLength, bLength); i++) {
            int aBit = (i < aLength) ? a.charAt(aLength - 1 - i) - '0' : 0;
            int bBit = (i < bLength) ? b.charAt(bLength - 1 - i) - '0' : 0;

            int sum = aBit + bBit + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }

        
        if (carry != 0) {
            result.append(carry);
        }

        
        return result.reverse().toString();
    }
 
    }
