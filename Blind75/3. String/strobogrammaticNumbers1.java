class Solution {

    Map<Character, Character> mp = new HashMap<>();

    public boolean isStrobogrammatic(String num) {
        mp.put('6', '9');
        mp.put('0', '0');
        mp.put('9', '6');
        mp.put('8', '8');
        mp.put('1', '1');

        StringBuilder sb = new StringBuilder();

        for(char c : num.toCharArray()){

            if (mp.containsKey(c))sb.append(mp.get(c));
            else return false;

        }

        return num.equals(sb.reverse().toString());

        
        
    }
}