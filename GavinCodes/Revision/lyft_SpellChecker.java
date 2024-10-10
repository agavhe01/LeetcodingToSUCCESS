 // Implement a spell checker!

 // Input:
 //     1) A text file with a newline-separated list of valid words ("the dictionary")
 //     2) A text file to be spellchecked, with words separated by newlines and spaces

 // Output: A list of all misspelled words from the "to be spellchecked" file.
 // (A misspelled word is one that does not appear in the dictionary.)

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;

class lyft_SpellChecker {
  public static void main(String[] args) {
    setup();

    List<String> typos = findTypos("dict.txt", "input.txt");
    System.out.println("Here are the Typos:");
    System.out.println(typos);
  }

  public static List<String> parseFile(String fileName){
    List<String> result = new ArrayList<>();
    File fp = new File(fileName);

    try {

        InputStream fis2 = new FileInputStream(fp);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis2));

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++){      
                Character aChar = line.charAt(i);
                if (Character.isLowerCase(aChar) || Character.isUpperCase(aChar)) sb.append(aChar);
                else{
                    if (sb.length() >= 1) { result.add(sb.toString()); }
                    sb = new StringBuilder();
                } 
            }//end for (i) 

            if (sb.length() >= 1) { result.add(sb.toString()); }
        }//end for (line)

    }

    catch(FileNotFoundException e){ throw new RuntimeException("Filenotfound Exc caught"); }
    catch(IOException e){ throw new RuntimeException("IOException caught"); }
    
    return result;

  }

  private static List<String> findTypos(String dictFile, String inputFile) {
    List<String> typos = new ArrayList<String>();  
    Set<String> dictionary = new HashSet<>(parseFile(dictFile));
    List<String> words = parseFile(inputFile);

    for (String word : words) if (! dictionary.contains(word) ) typos.add(word);
   
    return typos;
    
  }// end function
  
  /*

  public static List<String> makeDictionary(String filename){
    List<String> dict = new ArrayList<>();
    File f = new File(filename);
    try {
      InputStream fis = new FileInputStream(f);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis));
      for (String line = br.readLine(); line != null; line = br.readLine()) {
        dict.add(line);  
      }//endfor
    }
    catch(FileNotFoundException e){throw new RuntimeException("Filenotfound Exc caught");}
    catch(IOException e){throw new RuntimeException("IOException caught"); }
    
    return dict;
    
  }// end fundtion

  */

  private static void setup() {
    String dictionary = "analyze\nand\napplications\nare\nas\nbetween\nbuild\nbusiness\nby\nconsidering\ncost\ndesign\ndiscoveries\nengineering\nengineers\nEngineers\nforms\nfulfill\nhuman\nimposed\ninvent\nlife\nlimitations\nlink\nmachines\nmaterials\nneeds\nobjectives\nof\npeople\npracticality\npractitioners\nquality\nregulation\nrequirements\nsafety\nscientific\nstructures\nsubsequent\nsystems\ntest\nthe\nThe\ntheir\nto\nwhile\nwho\nwork";

    try (PrintWriter out = new PrintWriter("dict.txt")) {
      out.print(dictionary);
    } catch (FileNotFoundException e) {
      System.out.println("failed to write file dict.txt");
    }

    String input = "Engineers, as practitioners of engineering, are people who invent, design, analyze, build, and test machines, systems, \nstructures and materials to fulfill objectives and requirements while considering the limitationns imposed by practicality,\n regulation, safety, and costy. The work of engineers forms the link between scientific discoveries and their subsequent\n applications to human and business-needs and quality of life.";
    // Expected output: ['limitationns', 'costy']

    try (PrintWriter out = new PrintWriter("input.txt")) {
      out.print(input);
    } catch (FileNotFoundException e) {
      System.out.println("failed to write file input.txt");
    }
  }
}