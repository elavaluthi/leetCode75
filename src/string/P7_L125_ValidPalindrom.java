package string;

//Link:https://leetcode.com/problems/valid-palindrome/description/
//TimeComplexity: O(n)
//Type:Easy
public class P7_L125_ValidPalindrom {
	
	public static boolean isValid(String str) {
		if(str.isEmpty()) {
			return true;
		}
		
		int left=0;
		int right=str.length();
		
		while(left<right) {
			Character leftChar=str.charAt(left);
			Character rightChar=str.charAt(right);
			if(!Character.isLetterOrDigit(leftChar)) {
				left++;
			}else if(!Character.isLetterOrDigit(rightChar)) {
				right--;
			}else {
				if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)) {
					return false;
				}
				
				left++;
				right--;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String s) {
        // Convert the string to lowercase and filter out non-alphanumeric characters
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string reads the same forward and backward
        String filtered = filteredStr.toString();
        String reversed = filteredStr.reverse().toString();

        return filtered.equals(reversed);
    }
	
	
	public static void main(String[] args) {
	       
        System.out.println(isValid("A man, a plan, a canal: Panama")); // true
        System.out.println(isValid("race a car")); // false
        System.out.println(isValid(" ")); // true
        System.out.println(isValid("")); // true
        System.out.println(isValid("0P")); // false
    }

}
