public class longestPalindrome{

    static int start;
    static int end;


    public longestPalindrome(){ }

    /*
       
        TC : O(n ^ 2) 
        SC : O(1)
        REVISE UNDERSTAND HELPER 

    */
    public static String longestPal(String str){

        int n = str.length();
        
        start = 0;
        end = 0;

        for(int i = 0; i < n; i++){
            helper(str, i, i);      // odd checks
            helper(str, i, i + 1);  // even checks
        }

        return str.substring(start, end + 1);
    }

    // checks for palindromes beginning at left and right indexes 
    // 
    public static void helper(String str, int left, int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        left = left + 1;            // is palindrome beginning at  left + 1
        right = right - 1;          // is palindrome ending    at right - 1

        if (end - start + 1 < right - left + 1){
            start = left;
            end = right;
        }

    }

    public static void main(String[] args){
        longestPalindrome sol = new longestPalindrome();

        String res1 = sol.longestPal("babad");
        String res2 = sol.longestPal("cbbd");
        String res3 = sol.longestPal("aaa");
        String res4 = sol.longestPal("xsuusndbfaaabaaasjfbubbbsioenc");


        System.out.println("Res 1: bab || aba --> " + res1);
        System.out.println("Res 2:         bb --> " + res2);
        System.out.println("Res 3:        aaa --> " + res3);
        System.out.println("Res 4:    aaabaaa --> " + res4);
       
    }

}