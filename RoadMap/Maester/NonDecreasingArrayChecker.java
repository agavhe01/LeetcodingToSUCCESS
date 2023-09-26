import java.util.*;


public class NonDecreasingArrayChecker {
    public static boolean isNonDecreasing(List<Integer> a, List<Integer> b) {
                // Create a list to store the non-decreasing array.
                List<Integer> c = new ArrayList<>();

                // Iterate over the two lists.
                int i = 0;
                int j = 0;
                while (i < a.size() && j < b.size()) {
                    // If the current element in a is less than or equal to the current element in b,
                    // add the current element in a to the non-decreasing array.
                    if (a.get(i) <= b.get(j)) {
                    c.add(a.get(i));
                    i++;
                    j++;
                    }
                    // Otherwise, add the current element in b to the non-decreasing array.
                    else {
                    c.add(b.get(j));
                    j++;
                    i++;
                    }

                    // If the current element in the non-decreasing array is greater than the previous element,
                    // return false.
                    if (i > 0 && c.size() > 0 && i < c.size() && c.get(i) < c.get(i - 1)) {
                        return false;
                    }
                }

                // If we reach the end of both lists, return true.
                return (i == a.size() && j == b.size());
}


    public static void main(String[] args) {
        int[] a = {2, 7, 3};
        int[] b = {4, 2, 6};

        // boolean canFormC = isNonDecreasing(Arrays.asList(2,7,3), Arrays.asList(4,2,6));

        //boolean canFormC = isNonDecreasing(Arrays.asList(2,9,7), Arrays.asList(2,10,8));

        boolean canFormC = isNonDecreasing(Arrays.asList(45, 81, 29, 10), Arrays.asList(2,10,80, 0));


        if (canFormC) {
            System.out.println("A non-decreasing array c can be formed.");
        } else {
            System.out.println("A non-decreasing array c cannot be formed.");
        }
    }
}
