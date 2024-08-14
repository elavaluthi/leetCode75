package twoPointer;

public class P2_L125_ValidPalindrome {
	
	public static boolean validPalindrome(String str) {
		
		if(str.isEmpty()) {
			return true;
		}
		
		int left=0;
		int right=str.length()-1;
		
		while(left<=right) {
			
			Character currentLeft=str.charAt(left);
			Character currentRight=str.charAt(right);
			
			if(!Character.isLetterOrDigit(currentLeft)) {
				left++;
			}else if(!Character.isLetterOrDigit(currentRight)) {
				right--;
			}else {
				if(Character.toLowerCase(currentLeft) !=Character.toLowerCase(currentRight)) {
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
       
        System.out.println(validPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(validPalindrome("race a car")); // false
        System.out.println(validPalindrome(" ")); // true
        System.out.println(validPalindrome("")); // true
        System.out.println(validPalindrome("0P")); // false
    }

}
