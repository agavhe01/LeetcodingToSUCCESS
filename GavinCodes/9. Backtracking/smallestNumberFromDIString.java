/*


2375. Construct Smallest Number From DI String
Solved
Medium
Topics
Companies
Hint

You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

    num consists of the digits '1' to '9', where each digit is used at most once.
    If pattern[i] == 'I', then num[i] < num[i + 1].
    If pattern[i] == 'D', then num[i] > num[i + 1].

Return the lexicographically smallest possible string num that meets the conditions.

 

Example 1:

Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

Example 2:

Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.

 

Constraints:

    1 <= pattern.length <= 8
    pattern consists of only the letters 'I' and 'D'.


*/

class Solution {

    PriorityQueue<String> result = new PriorityQueue<>();

    public String smallestNumber(String pattern) {

        boolean[] visit = new boolean[10];
        int n = pattern.length();

        for(int i = 1; i <= 9; i++){
            visit[i] = true;
            int[] curr = new int[n + 1];
            curr[0] = i;
            helper(1, curr, pattern, n, visit);

            visit[i] = false;
        }
        return result.peek();     
    }

    public void helper(int index, int[] curr, String pattern, int n, boolean[] visit){
        if( index == n + 1){         
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < n + 1; i++) res.append(curr[i]);
            result.add(res.toString());
            return;
        }
        else if (index > n + 1) { return; }
        else{   
               if(Character.compare(pattern.charAt(index - 1), 'I') == 0){
                    for(int i = curr[index - 1] + 1; i <= 9; i++){
                        if (visit[i]) continue;

                        curr[index] = i;
                        visit[i] = true;
                        helper(index + 1, curr, pattern, n, visit);

                        visit[i] = false;

                    }
                } 
                else{
                    // decreasing
                    for(int i = curr[index - 1]; i >= 1; i--){
                        if (visit[i]) continue;

                        curr[index] = i;
                        visit[i] = true;
                        helper(index + 1, curr, pattern, n, visit);

                        visit[i] = false;
                    }
                }             
            }    
    }
}

/*

Better solution

class Solution {
    public String smallestNumber(String pattern) {

        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for(int i = 0; i <= pattern.length(); i++){
            Character c = (char)('1' + i);
            stack.append(c);
            if (i == pattern.length() || Character.compare(pattern.charAt(i), 'I') == 0 ){
                result.append(stack.reverse().toString());
                stack = new StringBuilder();
            }
        }

        return result.toString();
    }
}
*/