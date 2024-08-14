package arrayPrograms;

public class P02_L121_BuySellStock {

	public static int maxProfit(int[] prices) {
		int profit = 0;
		int buy = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
			} else if (prices[i] - buy > profit) {
				profit = prices[i] - buy;
			}
		}
		return profit;
	}

	public static void main(String[] args) {

		int prices1[] = { 7, 1, 5, 3, 6, 4 };
		int result1 = maxProfit(prices1);
		System.out.println("MaxProfit: [" + result1 + "]");

	}

}
