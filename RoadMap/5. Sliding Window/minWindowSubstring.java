import java.util.Map;
import java.util.HashMap;

class minWindowSubstring {
    public String minWindow(String s, String t) {

        int nS = s.length();

        int nT = t.length();

        Map<Character, Integer> tMap = new HashMap<>();

        String theWindow = "";
        int theWindowMinL = Integer.MAX_VALUE;

        for(char c: t.toCharArray()){
            //tMap.put(tMap.getOrDefault(c, 0) + 1);

            Integer count = tMap.getOrDefault(c, 0) + 1;
            tMap.put(Character.valueOf(c), count);
        }

        for(int i = 0; i < nS; i++){
            for(int j = i + nT; j <= nS ; j++){
                Map<Character, Integer> subMap = new HashMap<>();
                String subS = s.substring(i, j);
                //System.out.println(subS);

                for(char c: subS.toCharArray()){
                    //tMap.put(tMap.getOrDefault(c, 0) + 1);
                    Integer count = subMap.getOrDefault(c, 0) + 1;
                    subMap.put(Character.valueOf(c), count);
                }

                boolean found = true;

               for (Character key : tMap.keySet()) {
                   Integer cnt = subMap.getOrDefault(key, 0);
                   Integer cnt2 = tMap.getOrDefault(key, 0);
                   //System.out.println("Char: " + key + "  sub: " + cnt + "  t: " + cnt2);
                   if (cnt < cnt2){
                       found = false;
                   }
               }

               // 

                if(found && subS.length() < theWindowMinL ){
                    //System.out.println("Found!");
                    theWindowMinL = subS.length();
                    theWindow = subS;
                    
                }
                else{
                    subMap.clear();
                }



               
            }
        }
        return theWindow;
    }

    public static void main(String[] args) {
        String t = "ozgzyywxvtublcl";
        String s = "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        
        
        minWindowSubstring solution = new minWindowSubstring(); // Create an instance
        String rV = solution.minWindow(s, t); // Call the instance method
        String ans = "tcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanl";
        if( rV.equals(ans)){
            System.out.println("Solved!");
        }
        System.out.println(rV);
    }

    
}




/*

Better Solution that is O(N)


class Solution {

    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}


for the sliding window you need to figure out the condition that is requred to shift one of the pointers
In this case, shift the right pointer until you get a substring that contains all the characters
Once this happens, begin moving the left pointer unitil the point when all the characters do not appear anymore


*/
