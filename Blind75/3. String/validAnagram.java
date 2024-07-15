import java.util.Arrays;

public class validAnagram{

    public validAnagram(){}

    /*
       
        TC :   O( len1 + len2 + 256 ) = O(n) 
        SC :   O( 256 )               = O(1)
            // O( 2(256) )            = O(1)

    */

    public static boolean isValidAnagram(String str1, String str2){
        
        int n1 = str1.length();
        int n2 = str2.length();

        int[] map1 = new int[256];
        // int[] map2 = new int[256];

        for(int i = 0; i < n1; i++) map1[str1.charAt(i)]++;
        for(int i = 0; i < n2; i++) map1[str2.charAt(i)]--;
        // for(int i = 0; i < n2; i++) map2[str2.charAt(i)]++;

        // return Arrays.equals(map1, map2);
        return checkMap(map1); 
    }

    public static boolean checkMap(int[] map){
        for(int i = 0; i < 256; i++) if (map[i] != 0) return false;
        return true;
    }

    public static void main(String[] args){
        validAnagram sol = new validAnagram();

        boolean res1 = sol.isValidAnagram("anagram", "nagaram");
        boolean res2 = sol.isValidAnagram("rat", "car");
        boolean res3 = sol.isValidAnagram("abbbcZZ::", "cZabbZ:b:");
        boolean res4 = sol.isValidAnagram("abb bcZZ::", "cZab bZ:b:");
        boolean res5 = sol.isValidAnagram("abb bc Z::", "cZab bZ:b:");

        System.out.println("Res 1 :  true --> " + res1);
        System.out.println("Res 2 : false --> " + res2);
        System.out.println("Res 3 :  true --> " + res3);
        System.out.println("Res 4 :  true --> " + res4);
        System.out.println("Res 5 : false --> " + res5);


    }
}