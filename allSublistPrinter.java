public class allSublistPrinter {
    public static void main(String[] args) {
        String input = "abcdef";
        
        // Outer loop for the start index
        for (int start = 0; start < input.length(); start++) {
            // Inner loop for the end index
            for (int end = start + 1; end <= input.length(); end++) {
                // Extract the substring from start to end
                String substring = input.substring(start, end);
                System.out.println(substring);
            }
        }
    }
}