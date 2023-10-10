public class ReplaceNumbersWithQuestionMarks {
    public static String replaceNumbersWithQuestionMarks(String input) {
        StringBuilder result = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i < input.length(); i++){
            Character currChar = input.charAt(i);
            if (Character.isDigit(currChar)){
                if(currNum == 0){
                    currNum = Character.getNumericValue(currChar);
                }
                else{
                    currNum = (currNum * 10) + Character.getNumericValue(currChar);
                }

            }
            else{
                // check for currNum and add questions marks
                // add currChar after
                if(currNum != 0){
                    while(currNum > 0){
                        result.append('?');
                        currNum--;
                    }
                    currNum = 0;
                }
                result.append(currChar);
            }
        }

        if (currNum != 0){
            while(currNum > 0){
                    result.append('?');
                    currNum--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "ab3d";
        String input2 = "ab10c";
        String input3 = "abc0c";
        String input4 = "abc1c";
        String input5 = "abc101c";
        String input6 = "ab3d3rr10";
        String input7 = "3d3rr10";
         String input8 = "13d3rr10";
        

        String output1 = replaceNumbersWithQuestionMarks(input1);
        String output2 = replaceNumbersWithQuestionMarks(input2);
        String output3 = replaceNumbersWithQuestionMarks(input3);
        String output4 = replaceNumbersWithQuestionMarks(input4);
        String output5 = replaceNumbersWithQuestionMarks(input5);
        String output6 = replaceNumbersWithQuestionMarks(input6);
        String output7 = replaceNumbersWithQuestionMarks(input7);
         String output8 = replaceNumbersWithQuestionMarks(input8);

        System.out.println(output1);  // Output: "ab???d"
        System.out.println(output2);  // Output: "ab??????????c"
        System.out.println(output3);  
        System.out.println(output4);
        System.out.println(output5);
        System.out.println(output6);
        System.out.println(output7);
        System.out.println(output8);

        // is there is no char after the last digit (i.e digit is the last thing in the arr it does not add it)
    }
}
