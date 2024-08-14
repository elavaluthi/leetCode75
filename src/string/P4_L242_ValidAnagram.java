package string;

import java.util.*;

//Link:https://leetcode.com/problems/valid-anagram/description/
//TimeComplexity: O(n)
public class P4_L242_ValidAnagram {

public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
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
