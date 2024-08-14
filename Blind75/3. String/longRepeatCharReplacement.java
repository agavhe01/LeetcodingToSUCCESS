public class longRepeatCharReplacement{

    public longRepeatCharReplacement(){ }

    public static int findMaxLen(String str, int k){

        int[] map = new int[256];

        int right = 0, left = 0;
        int maxN = 0;
        int n = str.length();

        while (right < n){
            Character rightC = str.charAt(right);
           
            map[rightC]++;
            maxN = Math.max(maxN, map[rightC]);

            if (right - left + 1 - maxN > k){
                Character leftC = str.charAt(left);
                map[leftC]--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args){
        longRepeatCharReplacement sol = new longRepeatCharReplacement();

        String t1 = "ABAB";

        int res1 = sol.findMaxLen(t1, 2);

        System.out.println("Test 1 : 4 --> " + res1);
    }

}