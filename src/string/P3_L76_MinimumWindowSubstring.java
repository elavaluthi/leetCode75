package string;

import java.util.*;

//Link:https://leetcode.com/problems/minimum-window-substring/description/
//Type:Hard
//TimeComplexity=O(m+n)

public class P3_L76_MinimumWindowSubstring {

	public static String findMinWindowSubString(String str1, String str2) {

		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return "";
		}

		Map<Character, Integer> mapStr = new HashMap<>();

		for (char c : str2.toCharArray()) {
			mapStr.put(c, mapStr.getOrDefault(c, 0) + 1);
		}

		int required = mapStr.size();
		Map<Character, Integer> windowsCount = new HashMap<>();
		int left = 0, right = 0;
		int formed = 0;
		int ans[] = { -1, 0, 0 };

		while (right < str1.length()) {
			Character ch = str1.charAt(right);
			windowsCount.put(ch, windowsCount.getOrDefault(ch, 0) + 1);

			if (mapStr.containsKey(ch) && mapStr.get(ch).intValue() == windowsCount.get(ch).intValue()) {
				formed++;
			}

			while (left <= right && formed == required) {
				ch = str1.charAt(left);
				if (ans[0] == -1 || (right - left + 1)<ans[0]) {
					ans[0] = right - left + 1;
					ans[1] = left;
					ans[2] = right;
					System.out.println("ans:"+ans[0]+":"+ans[1]+":"+ans[2]);
				}
				windowsCount.put(ch, windowsCount.get(ch) - 1);
				if (mapStr.containsKey(ch) && windowsCount.get(ch).intValue() < mapStr.get(ch).intValue()) {
					formed--;
				}
				left++;
			}
			right++;
		}

		return ans[0] == -1 ? "" : str1.substring(ans[1], ans[2]+1);
	}
	
//	right=5,left=0,formed=3 ,ans[0]=6,ans[1]=0,ans[2]=5
//	right=10,left=1,formed=3,
//	left=9,right=12,fromed=2, ans[0]=5,ans[1]=8,ans[2]=12
//	left=9,right=12
	
	 public static void main(String[] args) {
	        
	        System.out.println(findMinWindowSubString("ADOBECODEBANC", "ABC")); // Output: "BANC"
	        System.out.println(findMinWindowSubString("a", "a")); // Output: "a"
	        System.out.println(findMinWindowSubString("a", "aa")); // Output: ""
	    }
}
