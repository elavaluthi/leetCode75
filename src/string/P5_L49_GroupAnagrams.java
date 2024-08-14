package string;

//Link:https://leetcode.com/problems/group-anagrams/
//TimeComplexity:O(n)
//Type:Medium
import java.util.*;
public class P5_L49_GroupAnagrams {
	
public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store the groups of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Check if the key already exists
            if (anagramMap.containsKey(sorted)) {
                // If it exists, add the string to the existing list
                anagramMap.get(sorted).add(s);
            } else {
                // If it does not exist, create a new list, add the string to it, and put it in the map
                List<String> list = new ArrayList<>();
                list.add(s);
                anagramMap.put(sorted, list);
            }
        }

        // Return all values in the hashmap as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

	public static void main(String[] args) {
        
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }


}
