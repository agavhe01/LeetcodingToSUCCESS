public class countPalindromes{

    public countPalindromes(){}

    public static int count(String str){
      
        int n = str.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            count += helper(str, i, i);
            count += helper(str, i, i + 1);
        }
        return count;
    }

    public static int helper(String str, int left, int right){
        int count = 0;
        int n = str.length();
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)){
            count += 1;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args){
        countPalindromes sol = new countPalindromes();

        int res1 = sol.count("abc");
        int res2 = sol.count("aaa");
        int res3 = sol.count("aaba");
        int res4 = sol.count("aac");


        System.out.println("Res 1: 3 --> " + res1);
        System.out.println("Res 2: 6 --> " + res2);
        System.out.println("Res 3: 6 --> " + res3);
        System.out.println("Res 4: 4 --> " + res4);




    }
}