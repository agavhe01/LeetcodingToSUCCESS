/*

CODING ROOMS PRACTICE TEST

Given two strings s and t, both consisting of lowercase English letters and digits, your task is to calculate how many ways exactly one digit could be removed from one of the strings so that s is lexicographically smaller than t after the removal. Note that we are removing only a single instance of a single digit, rather than all instances (eg: removing 1 from the string a11b1c could result in a1b1c or a11bc, but not abc).

Also note that digits are considered lexicographically smaller than letters.

Example

For s = "ab12c" and t = "1zz456", the output should be solution(s, t) = 1.

Here are all the possible removals:

We can remove the first digit from s, obtaining "ab2c". "ab2c" > "1zz456", so we don't count this removal
We can remove the second digit from s, obtaining "ab1c". "ab1c" > "1zz456", so we don't count this removal
We can remove the first digit from t, obtaining "zz456". "ab12c" < "zz456", so we count this removal
We can remove the second digit from t, obtaining "1zz56". "ab12c" > "1zz56", so we don't count this removal
We can remove the third digit from t, obtaining "1zz46". "ab12c" > "1zz46", so we don't count this removal
We can remove the fourth digit from t, obtaining "1zz45". "ab12c" > "1zz45", so we don't count this removal
The only valid case where s < t after removing a digit is "ab12c" < "zz456". Therefore, the answer is 1.


*/

int solution(String s, String t) {
    
    int nS = s.length();
    int nT = t.length();
    
    if (nT == 1 && nS == 1){
        if(Character.isDigit(s.charAt(0)) && "".compareTo(t) < 0){ return 1; }
        else{ return 0; }
    }
    
    int n = Math.max(nS, nT);
     
    int[] dpS = new int[n + 1];
    int[] dpT = new int[n + 1]; 
     
    for (int i = 0; i < n; i++){
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT= new StringBuilder();
        
        if (i < nS && Character.isDigit(s.charAt(i))){
            sbS.append(s.substring(0, i));
            sbS.append(s.substring(i + 1));
        }
        
        if (i < nT && Character.isDigit(t.charAt(i))){
            sbT.append(t.substring(0, i));
            sbT.append(t.substring(i + 1));
        }
    
        if (sbS.length() > 0 && sbS.toString().compareTo(t) < 0){ dpS[i + 1] = dpS[i] + 1; }
        else{ dpS[i + 1] = dpS[i]; } 
        
        if (sbT.length() > 0 && s.compareTo(sbT.toString()) < 0){ dpT[i + 1] = dpT[i] + 1; }
        else{ dpT[i + 1] = dpT[i]; } 
        
    }// endfor
   
    return dpT[n] + dpS[n];
}
