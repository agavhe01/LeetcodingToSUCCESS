// LEETCODE: 30

// You are given a string s and an array of strings words. All the strings of words are of the same length.

// A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
// Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

class SubstringConcatOfAllWords {
        public List<Integer> findSubstring(String s, String[] words) {

        
        if (s.isEmpty() || words.length == 0) {
        return new ArrayList<>();
        }

        // Initialize a list to store the starting indices of the concatenated substrings
        List<Integer> indices = new ArrayList<>();

        // Initialize a map to store the counts of each word in the array of words
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> currentCounts = new HashMap<>();
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;


         // Loop through the input string, checking for concatenated substrings at each position
        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            currentCounts.clear();

            // Loop through the words in the current substring and update their counts in the current counts map
            for (int j = 0; j < words.length; j++) {
            String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
            // System.out.println("Word:" + word);
            currentCounts.put(word, currentCounts.getOrDefault(word, 0) + 1);
            }

            // checks same key value pairs
            if (currentCounts.equals(wordCounts)) {
                indices.add(i);
            }
    

        }


        return indices;


        
    }
}