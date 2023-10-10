import java.util.Arrays;

public class PasswordReset {
    public static String findResultantString(String s) {
        int[] count = new int[26]; // Count occurrences of each letter
        int oddCount = 0; // Count of letters with odd occurrences
        char middleChar = ' '; // Middle character for the palindrome

        // Step 1: Count occurrences of each letter
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: Find the lowest letter with an odd count as the

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                middleChar = (char) ('a' + i);
                oddCount++;
            }
        }

        // If more than one letter has an odd count, it's not possible

        if (oddCount > 1) {
            return "Not possible";
        }

        char[] result = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;

        // Step 3: Create the left and right sides of the palindrome
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (count[i] >= 2) {
                result[left] = result[right] = c;
                left++;
                right--;
                count[i] -= 2;
            }
        }

        // Step 4: Use the remaining characters to minimize operations
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (count[i] > 0) {
                if (c < middleChar) {
                    result[left] = result[right] = c;
                } else if (c == middleChar && left == right) {
                    result[left] = middleChar;
                } else if (c > middleChar) {
                    if (result[left] != middleChar) {
                        result[left] = result[right] = c;
                    } else {
                        result[left] = result[right] = c;
                        count[i]--; // Avoid using the middle

                    }
                }
                left++;
                right--;
                count[i]--;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "aebcd";
        String result = findResultantString(s);
        System.out.println(result); // Output: "bedcb
    }
}