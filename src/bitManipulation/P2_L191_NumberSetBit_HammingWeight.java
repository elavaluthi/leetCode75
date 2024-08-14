package bitManipulation;

//Link:
//TimeComplexity:O(k) -> k is number of set bits
public class P2_L191_NumberSetBit_HammingWeight {
	
	public static int countSetBits(int n) {
		int count=0;
		while(n!=0) {
			n&=(n-1);
			count++;
		}
		return count;
	}
	
	 public static void main(String[] args) {
	        int n1 = 11; // binary 1011
	        int n2 = 128; // binary 10000000
	        int n3 = 2147483645; // binary 1111111111111111111111111111101

	        System.out.println("Number of set bits in " + n1 + " = " + countSetBits(n1));
	        System.out.println("Number of set bits in " + n2 + " = " + countSetBits(n2));
	        System.out.println("Number of set bits in " + n3 + " = " + countSetBits(n3));
	    }

}
