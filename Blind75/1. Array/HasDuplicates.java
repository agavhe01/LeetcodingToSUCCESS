import java.util.Set;
import java.util.HashSet;


public class HasDuplicates{

    static Set<Integer> st;


     /*
    
        TC : O(n)
        SC : O(n)

    */
    public static boolean hasDuplicates(int[] arr){
        st = new HashSet<Integer>();

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if (st.contains(num)) return true;
            st.add(num);
        }

        return false;

    }

    public static void main(String[] args){
        HasDuplicates hs = new HasDuplicates();

        int[] test1 = new int[]{2,7,11,15};

        int[] test2 = new int[]{1,2,3,1};

        Boolean res1 = hs.hasDuplicates(test1);
        System.out.println(res1);
        boolean res2 = hs.hasDuplicates(test2);
        System.out.println(res2);
    }
}