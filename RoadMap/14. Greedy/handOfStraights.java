/*

846. Hand of Straights

Medium

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.



*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        Arrays.sort(hand);
        
        for (int i = 0; i < hand.length; i++) {
            if (countMap.get(hand[i]) == 0) {
                continue;
            }
            
            for (int j = 0; j < groupSize; j++) {
                // Calculate currCard as the current card hand[i] plus j. This represents the card to be added to the group.
                int currCard = hand[i] + j;
                
                if (countMap.getOrDefault(currCard, 0) == 0) {
                    // If it's 0, it means the card is not available to form a group, so return false.


                    return false;
                }
                
                //  decrement its count in countMap to indicate that it has been used in a group.
                countMap.put(currCard, countMap.get(currCard) - 1);
            }
        }
        
        return true;
    }
}