/*

1286. Iterator for Combination
Solved
Medium
Topics
Companies
Hint
Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 

Example 1:

Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False

*/

class CombinationIterator {

    List<String> result;
    int currentIndex;

    /*

    This constructor has a complexity of O(2^n * n), where n is the length of the input string characters. 
    The O(2^n) factor accounts for generating all combinations, and O(n) for appending characters to form each combination. 
    
    The complexities of next() and hasNext() remain O(1).

    */

    public CombinationIterator(String characters, int combinationLength) {
        result = new ArrayList<>();
        helper(0, characters, combinationLength, new StringBuilder(), result);
        Collections.sort(result);
        currentIndex = 0;
    }
    
    public String next() {
        currentIndex++;
        return result.get(currentIndex - 1);
    }
    
    public boolean hasNext() {
        return currentIndex < result.size();
    }

    private void helper(
        int index,
        String characters,
        int k,
        StringBuilder current,
        List<String> result
    ){
        if (current.length() == k) result.add(new String(current.toString())); 
        else if (current.length() > k || index >= characters.length()) return;
        else{
            current.append(characters.charAt(index));
            helper(index + 1, characters, k, current, result);
            current.deleteCharAt(current.length() - 1);
            helper(index + 1, characters, k, current, result);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


 /*

 ALTERNATIVE


class CombinationIterator {

    List<String> result;
    int currentIndex;

    public CombinationIterator(String characters, int combinationLength) {
        result = new ArrayList<>();
        helper(0, characters, combinationLength, new StringBuilder(), result);
        //Collections.sort(result);
        currentIndex = 0;
    }
    
    public String next() {
        currentIndex++;
        System.out.println(result.size());
        return result.get(currentIndex - 1);
        
    }
    
    public boolean hasNext() {
        return currentIndex < result.size();
    }

    private void helper(
        int index,
        String characters,
        int k,
        StringBuilder current,
        List<String> result
    ){
        if (current.length() == k) result.add(new String(current.toString())); 
        else if (current.length() > k || index >= characters.length()) return;
        else{
            for(int i = index; i < characters.length(); i++){
                // if we are checking for duplicate characters
                // if (i > index && characters[i] == characters[i + 1]) continue;
                current.append(characters.charAt(i));
                helper(i + 1, characters, k, current, result);
                current.deleteCharAt(current.length() - 1);

            }
        }
    }
}


 */