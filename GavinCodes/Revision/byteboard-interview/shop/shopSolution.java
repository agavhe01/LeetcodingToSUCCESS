
import java.util.*;

public class shopSolution {

    // Function to compute penalty given the store log and closing time
    public static int compute_penalty(String log, int closing_time) {
        int penalty = 0;
        // Loop through each hour of the log
        for (int i = 0; i < log.length(); i++) {
            if (i < closing_time) {
                // Store is open during this hour
                if (log.charAt(i) == 'N') {
                    penalty++;  // Open but no customers
                }
            } else {
                // Store is closed during this hour
                if (log.charAt(i) == 'Y') {
                    penalty++;  // Closed but customers wanted to shop
                }
            }
        }
        return penalty;
    }

    // Function to find the best closing time with the minimum penalty
    public static int find_best_closing_time(String log) {
        int best_closing_time = 0;
        int min_penalty = Integer.MAX_VALUE;

        // Try all possible closing times from 0 to log.length()
        for (int closing_time = 0; closing_time <= log.length(); closing_time++) {
            int current_penalty = compute_penalty(log, closing_time);
            // Update best closing time if a smaller penalty is found
            if (current_penalty < min_penalty) {
                min_penalty = current_penalty;
                best_closing_time = closing_time;
            }

            // if there is a tie in penalty, we pick the least since it costs more to have the store open coz 
            // employees need to get. if penalty is same better off closing earlier and saving costs 
            // of keeping store open for extra
            else if (current_penalty == min_penalty){
                best_closing_time = Math.min(closing_time, best_closing_time);
            }
        }
        return best_closing_time;
    }

    public static void main(String[] args) {
        // Test cases based on the provided output expectations
        System.out.println("Test Case 1");
        System.out.println(compute_penalty("YYNY", 0));  // Should return 3
        System.out.println(compute_penalty("NYNY", 2));  // Should return 2
        System.out.println(compute_penalty("YYNY", 4));  // Should return 1

        System.out.println(compute_penalty("YYYY", 1));  // Should return 3
        System.out.println(compute_penalty("NNNN", 4));  // Should return 4
        System.out.println(compute_penalty("NNNN", 0));  // Should return 0
        

        System.out.println("Test Case 2");
        // Testing the best closing time function
        System.out.println(find_best_closing_time("YYNY"));  // Should return 2
        System.out.println(find_best_closing_time("YYNN"));  // Should return 2
        
        // Additional test cases

        // Test Case 3: Store never opens (empty log)
        System.out.println("Test Case 3");
        System.out.println(compute_penalty("", 0));  // Should return 0
        System.out.println(find_best_closing_time(""));  // Should return 0

        // Test Case 4: All hours are busy with customers ('Y' for every hour)
        System.out.println("Test Case 4");
        System.out.println(compute_penalty("YYYY", 2));  // Should return 2
        System.out.println(compute_penalty("YYYY", 0));  // Should return 4
        System.out.println(compute_penalty("YYYY", 4));  // Should return 0
        System.out.println(find_best_closing_time("YYYY"));  // Should return 4

        // Test Case 5: No customers ('N' for every hour)
        System.out.println("Test Case 5");
        System.out.println(compute_penalty("NNNN", 2));  // Should return 2
        System.out.println(compute_penalty("NNNN", 0));  // Should return 0
        System.out.println(compute_penalty("NNNN", 4));  // Should return 4
        System.out.println(find_best_closing_time("NNNN"));  // Should return 0

        // Test Case 6: Alternating customer presence
        System.out.println("Test Case 6");
        System.out.println(compute_penalty("YNYN", 2));  // Should return 2
        System.out.println(compute_penalty("YNYN", 1));  // Should return 1
        System.out.println(compute_penalty("YNYN", 3));  // Should return 1
        System.out.println(compute_penalty("YNYN", 4));  // Should return 2 
        System.out.println(find_best_closing_time("YNYN"));  // Should return 1 OR 3

        // Test Case 7: Edge case with only one hour
        System.out.println("Test Case 7");
        System.out.println(compute_penalty("Y", 0));  // Should return 1
        System.out.println(compute_penalty("Y", 1));  // Should return 0
        System.out.println(compute_penalty("N", 0));  // Should return 0
        System.out.println(compute_penalty("N", 1));  // Should return 1
        System.out.println(find_best_closing_time("Y"));  // Should return 1
        System.out.println(find_best_closing_time("N"));  // Should return 0

        // Test Case 8: All hours with customers, best closing time should be after all hours
        System.out.println("Test Case 8");
        System.out.println(compute_penalty("YYYY", 0));  // Should return 4
        System.out.println(compute_penalty("YYYY", 3));  // Should return 1
        System.out.println(find_best_closing_time("YYYY"));  // Should return 4

        // Test Case 9: No customers, penalty should always be 0 for any closing time
        System.out.println("Test Case 9");
        System.out.println(compute_penalty("NNNN", 0));  // Should return 0
        System.out.println(compute_penalty("NNNN", 2));  // Should return 2
        System.out.println(find_best_closing_time("NNNN"));  // Should return 0
    }
}


/*

import java.util.*;

public class shopSolution {

    // Function to compute penalty given the store log and closing time
    public static int compute_penalty(String log, int closing_time) {
        int penalty = 0;
        // Loop through each hour of the log
        for (int i = 0; i < log.length(); i++) {
            if (i < closing_time) {
                // Store is open during this hour
                if (log.charAt(i) == 'N') {
                    penalty++;  // Open but no customers
                }
            } else {
                // Store is closed during this hour
                if (log.charAt(i) == 'Y') {
                    penalty++;  // Closed but customers wanted to shop
                }
            }
        }
        return penalty;
    }

    // Function to find the best closing time with the minimum penalty
    public static int find_best_closing_time(String log) {
        int best_closing_time = 0;
        int min_penalty = Integer.MAX_VALUE;

        // Try all possible closing times from 0 to log.length()
        for (int closing_time = 0; closing_time <= log.length(); closing_time++) {
            int current_penalty = compute_penalty(log, closing_time);
            // Update best closing time if a smaller penalty is found
            if (current_penalty < min_penalty) {
                min_penalty = current_penalty;
                best_closing_time = closing_time;
            }
        }
        return best_closing_time;
    }

    public static void main(String[] args) {
        // Test cases based on the examples in the screenshots
        System.out.println(compute_penalty("YYNY", 0));  // Should return 3
        System.out.println(compute_penalty("NYYNY", 2));  // Should return 2
        System.out.println(compute_penalty("YYNY", 4));  // Should return 1

        // Testing the best closing time function
        System.out.println(find_best_closing_time("YYNY"));  // Should return 2
        System.out.println(find_best_closing_time("YYNN"));  // Example where store should close at time 2
    }
}

*/