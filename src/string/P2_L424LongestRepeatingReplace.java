package string;

public class P2_L424LongestRepeatingReplace {

	public static int findLongestRepeatReplace(String str, int k) {
		int maxCount = 0, maxLength = 0;
		int left = 0;
		int count[] = new int[26];

		for (int right = 0; right < str.length(); right++) {
			count[str.charAt(right) - 'A']++;
			maxCount = Math.max(maxCount, count[str.charAt(right) - 'A']);
			
			if(right-left+1-maxCount>k) {
				count[str.charAt(left) - 'A']--;
				left++;
			}
			
			maxLength=Math.max(maxLength, right-left+1);
		}

		return maxLength;
	}
	
	public static void main(String[] args) {
		String s1 = "ABAB";
        int k1 = 2;
        System.out.println(findLongestRepeatReplace(s1, k1)); // Output: 4
        
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(findLongestRepeatReplace(s2, k2)); // Output: 4
	}

}

/*
 *Step-by-Step Breakdown
right = 0, s[right] = 'A'

count['A' - 'A']++ -> count[0]++ -> count = [1, 0, ..., 0]
maxCount = max(maxCount, count[0]) -> maxCount = max(0, 1) = 1
Window size = right - left + 1 = 1
right - left + 1 - maxCount = 1 - 1 = 0 (This is <= k)
maxLength = max(maxLength, right - left + 1) = max(0, 1) = 1
maxLength = 1


right = 1, s[right] = 'A'

count['A' - 'A']++ -> count[0]++ -> count = [2, 0, ..., 0]
maxCount = max(maxCount, count[0]) -> maxCount = max(1, 2) = 2
Window size = right - left + 1 = 2
right - left + 1 - maxCount = 2 - 2 = 0 (This is <= k)
maxLength = max(maxLength, right - left + 1) = max(1, 2) = 2
maxLength = 2


right = 2, s[right] = 'B'

count['B' - 'A']++ -> count[1]++ -> count = [2, 1, ..., 0]
maxCount = max(maxCount, count[0]) -> maxCount = max(2, 1) = 2
Window size = right - left + 1 = 3
right - left + 1 - maxCount = 3 - 2 = 1 (This is <= k)
maxLength = max(maxLength, right - left + 1) = max(2, 3) = 3
maxLength = 3


right = 3, s[right] = 'A'

count['A' - 'A']++ -> count[0]++ -> count = [3, 1, ..., 0]
maxCount = max(maxCount, count[0]) -> maxCount = max(2, 3) = 3
Window size = right - left + 1 = 4
right - left + 1 - maxCount = 4 - 3 = 1 (This is <= k)
maxLength = max(maxLength, right - left + 1) = max(3, 4) = 4
maxLength = 4


right = 4, s[right] = 'B'

count['B' - 'A']++ -> count[1]++ -> count = [3, 2, ..., 0]
maxCount = max(maxCount, count[0]) -> maxCount = max(3, 2) = 3
Window size = right - left + 1 = 5
right - left + 1 - maxCount = 5 - 3 = 2 (This is > k)
Window is invalid, so shrink from the left:
count['A' - 'A']-- -> count[0]-- -> count = [2, 2, ..., 0]
left++ -> left = 1
maxLength remains 4 since the window size didn't increase.
maxLength = 4


right = 5, s[right] = 'B'

count['B' - 'A']++ -> count[1]++ -> count = [2, 3, ..., 0]
maxCount = max(maxCount, count[1]) -> maxCount = max(3, 3) = 3
Window size = right - left + 1 = 5
right - left + 1 - maxCount = 5 - 3 = 2 (This is > k)
Window is invalid, so shrink from the left:
count['A' - 'A']-- -> count[0]-- -> count = [1, 3, ..., 0]
left++ -> left = 2
maxLength remains 4 since the window size didn't increase.
maxLength = 4


right = 6, s[right] = 'A'

count['A' - 'A']++ -> count[0]++ -> count = [2, 3, ..., 0]
maxCount = max(maxCount, count[1]) -> maxCount = max(3, 3) = 3
Window size = right - left + 1 = 5
right - left + 1 - maxCount = 5 - 3 = 2 (This is > k)
Window is invalid, so shrink from the left:
count['B' - 'A']-- -> count[1]-- -> count = [2, 2, ..., 0]
left++ -> left = 3
maxLength remains 4 since the window size didn't increase.
maxLength = 4

Final Result
After iterating through the entire string with the sliding window approach, the maximum length of the valid window found is 4.
 *
 *
 *
 */
