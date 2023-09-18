/*

PURPOSE: 
java function that accepts  a List<List<Character>> array and returns all possible string combinations of
array following these constraints: 
        the first character should come from array[0], second character from [1] etc. 
        so if array.length() = 5 then all string combinations must be of length 5, 
        featuring one element from each of the respective sublists



DOCUMENTATION:
The generateCombinations method is the entry point for generating combinations. 
It initializes an empty list called combinations and then calls the helper function generateCombinationsHelper to start generating combinations.

The generateCombinationsHelper method is a recursive function. It takes the following parameters:

array: The list of lists containing characters.
index: The current index in the array of lists.
current: A StringBuilder that keeps track of the current combination being built.
combinations: The list of generated combinations.
Inside the generateCombinationsHelper method:

If index equals the size of the array, it means we have successfully constructed a combination of characters from all sublists. 
In this case, we add the current combination (represented by the current StringBuilder) to the combinations list.
We iterate through the characters in the sublist at the current index. 
For each character, we append it to the current StringBuilder, recursively call the helper function with the next index, and then remove the last character added (backtrack) to explore other combinations.

The main method demonstrates how to use the CombinationsGenerator class by providing a sample array of lists and printing the generated combinations.



*/
import java.util.ArrayList;
import java.util.List;

public class CombinationsGenerator {
    public List<String> generateCombinations(List<List<Character>> array) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsHelper(array, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void generateCombinationsHelper(List<List<Character>> array, int index, StringBuilder current, List<String> combinations) {
        if (index == array.size()) {
            combinations.add(current.toString());
            return;
        }

        List<Character> currentList = array.get(index);
        for (Character character : currentList) {
            current.append(character);
            generateCombinationsHelper(array, index + 1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Character>> array = new ArrayList<>();
        array.add(List.of('a', 'b', 'c'));
        //array.add(List.of('d', 'e', 'f'));
        //array.add(List.of('X', 'Y', 'Z'));

        CombinationsGenerator generator = new CombinationsGenerator();
        List<String> combinations = generator.generateCombinations(array);

        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
