/*

Leetcode: 670 Maximum Swap

Medium

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.


*/

class Solution {
    public int maximumSwap(int num) 
    {

        /*
        temp is used for determining the place value of the digit currently being examined. 
        index tracks the place value of the maximum digit found so far.
        maxdigit stores the maximum digit found so far.
        d stores the difference caused by the current swap

        */
        int max_digit = 0;
        int diff = 0;
        int temp = 1, index = 1;  
        int n = num;
        
        while(n > 0)
        {
            int digit = n % 10; // Extracts the least significant digit.
            n = n/10; // Removes the least significant digit from n.

            /*
The code checks if the current digit is less than the maximum digit found so far (if (max_digit > digit)). If it is, it calculates the effect of swapping these two digits and updates d to be the maximum possible improvement.
            */
            
            if(max_digit > digit)
            /*
            This calculates the difference made by swapping the current digit with the maximum digit found so far, considering their place values.

            */
                diff = Math.max(diff , (max_digit-digit) * (temp-index));
            
            else if(max_digit < digit)
            /*
If the current digit is greater than the maximum digit found so far it updates max_digit with the current digit and index with the current place value.
            */
            {
                max_digit = digit;
                index = temp;
            }
            
            temp = temp*10;
        }
        
        return num + diff;
    }
}


/*

Same solution re-written in lintcode

public class Solution {
    
    public int maximumSwap(int num) {
        // Write your code here

        int diff = 0;           // current diff so far
        int index = 1;          // place value of the max digit
        int maxDigit = 0;       // maxdigit encountered so far
        int temp = 1;           // place value of the current digit being considered

        int n = num;

        while(n > 0){
            int digit = n % 10; // extract digit
            n = n / 10;         // remove lsd from negative

            if (maxDigit > digit){
                diff = Math.max(diff, ((maxDigit - digit) * (temp - index)));
            }
            else if (maxDigit < digit){
                maxDigit = digit;
                index = temp;
            }
            temp = temp * 10;
        }
        return num + diff;
    }
}

/*