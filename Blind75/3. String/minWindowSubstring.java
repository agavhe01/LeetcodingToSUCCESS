import java.util.HashMap;
import java.util.Map;

public class minWindowSubstring

{

    public minWindowSubstring(){}

    public static String minWindow(String str1, String str2){
       Map<Character, Integer> map = new HashMap<Character, Integer>();

       int n1 = str1.length(), n2 = str2.length();
       if (n2 > n1) return "";

       for(int i = 0; i < n2; i++){ 
            Character c = str2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
       }
      
       int start = 0, matched = 0;
       int windowStart = -1, minLen = Integer.MAX_VALUE;
       
       for(int end = 0; end < n1; end++){
            Character ch = str1.charAt(end);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) matched++;
            }

            while (matched == map.size()){
                if (minLen > end - start + 1){
                    minLen = end - start + 1;
                    windowStart = start;
                }

                Character deleted = str1.charAt(start++);
                if (map.containsKey(deleted)){
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
       } // endfor

       return minLen > n1 ? "" : str1.substring(windowStart, windowStart + minLen);

    }


    public static void main(String[] args) {
        String t = "ozgzyywxvtublcl";
        String s = "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        
        
        minWindowSubstring solution = new minWindowSubstring();
        String res = solution.minWindow(s, t);
        String ans = "tcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanl";
        if( res.equals(ans)){
            System.out.println("Solved!");
        }
        // System.out.println(res);
    }
}