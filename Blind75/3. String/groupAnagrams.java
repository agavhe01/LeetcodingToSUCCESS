import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class groupAnagrams{

    public groupAnagrams(){}

    public List<List<String>> createGroups(String[] strs){

        Map<List<Integer>, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] currMap = new int[256];

            for(Character c: str.toCharArray()) currMap[c]++;

            List<Integer> integerList = new ArrayList<>(currMap.length);
            for (int val : currMap) integerList.add(val); 

            List<String> vals;
            if (map.containsKey(integerList)){
                vals = map.get(integerList);
                vals.add(str);
                map.put(integerList, vals);
            }
            else{
                vals = new ArrayList<String>();
                vals.add(str);
                map.put(integerList, vals);
            }


        }
        
        return new ArrayList<>(map.values());  
    }

    public void printArray(List<List<String>> arr){
        for(List<String> ll : arr){
            System.out.print("[ ");
            for(String s: ll){
                System.out.print(s + "  ");
            }
            System.out.println(" ]");
        }
    }

    public static void main(String[] args){
        groupAnagrams sol = new groupAnagrams();

        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = sol.createGroups(arr);
        sol.printArray(res);

        System.out.println("Done");
    }
}

/*

BETTER SOLUTION COMPEXXITY O(n * m log m)

} // TC: O(n * k * log k), SC: O(n * k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);

            if (!map.containsKey(str)){
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());       
    }
}

*/