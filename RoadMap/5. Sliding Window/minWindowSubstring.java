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