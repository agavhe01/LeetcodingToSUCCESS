/*

306. Additive Number
Solved
Medium
Topics
Companies

An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: 
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

Example 2:

Input: "199100199"
Output: true
Explanation: 
The additive sequence is: 1, 99, 100, 199. 
1 + 99 = 100, 99 + 100 = 199

 

Constraints:

    1 <= num.length <= 35
    num consists only of digits.

 

Follow up: How would you handle overflow for very large input integers?

*/


import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        for(int i = 1; i <= n / 2; i++){
            for(int j = i + 1; j < n; j++){
                String one = num.substring(0, i);
                String two = num.substring(i, j);
                String rest = num.substring(j);

                if (isValidNum(one) && isValidNum(two) && isValidSeq(one, two, rest)) return true;
            }
        }

        return false;
        
    }

    public boolean isValidNum(String num){
        if (num.length() > 1 && num.charAt(0) == '0') return false;  // Invalid if leading zero and length > 1
        return true;  // 
    }

    public boolean isValidSeq(String one, String two, String rest){
        if (rest.length() == 0) return true;
        BigInteger o = new BigInteger(one);
        BigInteger t = new BigInteger(two);
        String sum = o.add(t).toString();
        if (! rest.startsWith(sum)) return false;
        return isValidSeq(two, sum, rest.substring(sum.length()));

    }
}

/*

No  Big integer? 

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                String one = num.substring(0, i);
                String two = num.substring(i, j);
                String rest = num.substring(j);

                if (isValidNum(one) && isValidNum(two) && isValidSeq(one, two, rest)) return true;
            }
        }
        return false;
    }

    public boolean isValidNum(String num) {
        if (num.length() > 1 && num.charAt(0) == '0') return false;  // Invalid if leading zero and length > 1
        return true;  // "0" is valid
    }

    public boolean isValidSeq(String one, String two, String rest) {
        if (rest.length() == 0) return true;
        String sum = addStrings(one, two);  // Use the string-based addition function
        if (!rest.startsWith(sum)) return false;
        return isValidSeq(two, sum, rest.substring(sum.length()));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}

*/

