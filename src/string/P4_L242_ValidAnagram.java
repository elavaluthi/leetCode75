package string;

import java.util.*;

//Link:https://leetcode.com/problems/valid-anagram/description/
//TimeComplexity: O(n)
public class P4_L242_ValidAnagram {

	public static boolean isAnagram(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Integer> countMap = new HashMap<>();
		
//		str1.chars().forEach(c->{
//			countMap.put((char)c, countMap.getOrDefault(c, 0) + 1);
//		});

		for (char c : str1.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		

		for (char c : str2.toCharArray()) {
			if (!countMap.containsKey(c)) {
				return false;
			}

			countMap.put(c, countMap.getOrDefault(c, 0) - 1);
			if (countMap.get(c) == 0) {
				countMap.remove(c);
			}
		}

		return countMap.isEmpty();
	}
	
	public static void main(String[] args) {
                
        // Test cases
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1)); // Output: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // Output: false

        // Test case with Unicode characters
        String s3 = "ańagram";
        String t3 = "ńagrama";
        System.out.println(isAnagram(s3, t3)); // Output: true
    }

}
