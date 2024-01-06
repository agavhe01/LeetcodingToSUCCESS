/*

Leetcode: 1891. Cutting Ribbons

You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k. You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.

For example, if you have a ribbon of length 4, you can:
Keep the ribbon of length 4,
Cut it into one ribbon of length 3 and one ribbon of length 1,
Cut it into two ribbons of length 2,
Cut it into one ribbon of length 2 and two ribbons of length 1, or
Cut it into four ribbons of length 1.
Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.

Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.


*/


class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1;
        int r = (int) 1e5 + 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);  // divides (l-r by 2)
            
            if (!isCutPossible(ribbons, mid, k)) {
                r = mid;

                //  it means mid is too long, and we cannot get at least k ribbons of this length. Therefore, the upper bound r is updated to mid.
            } else {
                l = mid + 1;

                // so we try to see if a longer ribbon is possible by setting the lower bound l to mid + 1.
            }
        }
        return l - 1;
    }

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        for (int ribbon: ribbons) {
            count += (ribbon / length);
        }
        return count >= k;
    }

}