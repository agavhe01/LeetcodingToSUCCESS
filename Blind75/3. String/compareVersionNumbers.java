/*

165. Compare Version Numbers
Solved
Medium
Topics
Companies
Hint

Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.

To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.

Return the following:

    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.

 

Example 1:

Input: version1 = "1.2", version2 = "1.10"

Output: -1

Explanation:

version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.

Example 2:

Input: version1 = "1.01", version2 = "1.001"

Output: 0

Explanation:

Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 3:

Input: version1 = "1.0", version2 = "1.0.0.0"

Output: 0

Explanation:

version1 has less revisions, which means every missing revision are treated as "0".

 
*/

class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length;
        int n2 = v2.length;

        for(int i = 0; i < Math.max(n1, n2); i++){
            String s1 = (i < n1) ? v1[i] : "0";
            String s2 = (i < n2) ? v2[i] : "0";

            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);

            if (i1 > i2) return 1;
            else if (i1 < i2) return -1;

        }

        return 0;

        
    }

    public void print(String[] arr){
        for(String s : arr){
            System.out.print(s + " ");
        }
    }
}

/*

NO EXTRA SPACE

class Solution {
    public int compareVersion(String version1, String version2) {

        int i = 0;
        int j = 0;

        int n1 = version1.length();
        int n2 = version2.length();

        while (i < n1 || j < n2){
            int num1 = 0;
            int num2 = 0;

            while (i < n1 && version1.charAt(i) != '.'){
                num1 = (num1 * 10) + (version1.charAt(i) - '0'); 
                i++;
            }

            while (j < n2 && version2.charAt(j) != '.'){
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;

            i++;
            j++;
        }
        return 0;
    }
}

*/