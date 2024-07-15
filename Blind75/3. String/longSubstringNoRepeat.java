public class longSubstringNoRepeat{

    public longSubstringNoRepeat(){ }

    public int longestSubstring(String str){
        int n = str.length();

        if (n == 0) return 0;

        int[] map = new int[256];
        int result = Integer.MIN_VALUE;
        int right = 0;

        for(int left = 0; left < n; left++){
            while (right < n && map[str.charAt(right)] == 0){
                map[str.charAt(right)] = 1;
                result = Math.max(result, right - left + 1);
                right++;
            }
            map[str.charAt(left)] = 0;
        }
        return result;
    }
    
    public static void main(String[] args){

        longSubstringNoRepeat sol = new longSubstringNoRepeat();

        String t1 ="abcabcbb";
        int res1 = sol.longestSubstring(t1);
        System.out.println("Result 1: 3 --> " + res1);

        String t2 ="pwwkew";
        int res2 = sol.longestSubstring(t2);
        System.out.println("Result 2: 3 --> " + res2);

        String t3 ="bbbbbb";
        int res3 = sol.longestSubstring(t3);
        System.out.println("Result 3: 1 --> " + res3);

        String t4 ="anesugavhera";
        int res4 = sol.longestSubstring(t4);
        System.out.println("Result 4: 8 --> " + res4);
        
    }

}