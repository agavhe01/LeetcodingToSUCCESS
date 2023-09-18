
/*

LEETCODE: 347. Top K Frequent Elements
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


*/

class Solution {
    public int[] topKFrequent(int[] words, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (Integer word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<Integer> rec = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }


        /*
It first compares the values associated with word1 and word2 in the cnt map using cnt.get(word1) and cnt.get(word2).

If the values are equal (cnt.get(word1) == cnt.get(word2)), it falls back to comparing the integers themselves using word1.compareTo(word2). This ensures that if two integers have the same associated value in the cnt map, they will be sorted in ascending order.

If the values are not equal, it sorts in descending order by subtracting cnt.get(word1) from cnt.get(word2). This means that integers with higher values in the cnt map will come before integers with lower values.


        */
        Collections.sort(rec, new Comparator<Integer>() {
            public int compare(Integer word1, Integer word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });

        //return rec.subList(0, k);


        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = rec.get(i);
        }
        return array;


    }
        
    
}

