/*

LINTCODE: 659 Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"


*/



public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
   
        StringBuilder strb = new StringBuilder("");
        
        for (int i = 0; i < strs.size(); i++) {
            
            if (i != 0)
                strb.append(":;");
            
            for (int j = 0; j < strs.get(i).length(); j++) {
                char c = strs.get(i).charAt(j);
                if (c == ':')
                    strb.append(':');
                strb.append(c);
            }
        }
      
        return strb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
       
        ArrayList<String> res = new ArrayList<String>();
      
        StringBuilder strb = new StringBuilder("");
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(i);
            
            if (c == ':') {
                
                c = str.charAt(++i);
                
                if (c == ':')
                    strb.append(c);
              
                else if (c == ';') {
                    res.add(strb.toString());
                    strb.delete(0, strb.length()); // clears 
                    
                }
                continue;
            }
           
            strb.append(c);
        }
        
        res.add(strb.toString());
       
        return res;
    }
}