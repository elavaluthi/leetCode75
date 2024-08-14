package bitManipulation;

//Link: https://leetcode.com/problems/sum-of-two-integers/description/
//TimeComplexity:O(n)
public class P1_L371_SumOfIntegers {
	
	    public static int getSum(int a, int b) {
	        while (b != 0) {
	            int carry = a & b; // Calculate carry
	            // If both bits are 1, the corresponding result bit is set to 1. Otherwise, the corresponding result bit is set to 0
	            System.out.println("carry:"+carry);
	            a = a ^ b; // Calculate sum without carry
	            // If the bits are different, the corresponding result bit is set to 1. If the bits are the same, the corresponding result bit is set to 0.
	            System.out.println("sum without carry:"+a);
	            b = carry << 1; // Shift carry to the left
	            System.out.println("shift carry to left:"+b);
	        }
	        return a;
	    }

	    public static void main(String[] args) {

	        System.out.println(getSum(1, 2)); // Output: 3
	        System.out.println(getSum(2, 3)); // Output: 5
	    }

}
