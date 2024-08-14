package bitManipulation;

import java.util.*;

//Link:https://leetcode.com/problems/reverse-bits/description/
//TimeComplexity:O(1)
public class P5_L190_ReverseBits {
	private final static Map<Integer, Integer> cache = new HashMap<>();

	public static int reverseBits(int n) {
		if (cache.containsKey(n)) {
            return cache.get(n);
        }
		
		int result = 0;
		int originalN=n;
		for (int i = 0; i < 32; i++) {
			// Extract the rightmost bit of n and add it to result
			result = (result << 1) | (n & 1);
			// Shift n right to process the next bit
			n = n >> 1;
		}
		cache.put(originalN, result);
		return result;
	}

	public static void main(String[] args) {

		int n1 = 0b00000010100101000001111010011100;
		int n2 = 0b11111111111111111111111111111101;

		int result1 = reverseBits(n1);
		int result2 = reverseBits(n2);

		System.out.println("Signed output:");
		System.out.println(result1); // Output: 964176192
		System.out.println(result2); // Output: -1073741825

		System.out.println("Unsigned output:");
		System.out.println(Integer.toUnsignedString(result1)); // Output: 964176192
		System.out.println(Integer.toUnsignedString(result2)); // Output: 3221225471
	}

}
