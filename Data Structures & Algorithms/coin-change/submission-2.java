class Solution {
    public int coinChange(int[] coins, int amount) {
		Map<Integer, Integer> memo = new HashMap<>();
		int requiredCoins = findMinimumCoins(coins, amount, memo);

        if (requiredCoins == Integer.MAX_VALUE - 1) return -1;
        return requiredCoins;
	}

	private int findMinimumCoins(int [] coins, int amount, Map<Integer, Integer> memo ) {
		if (amount == 0) return 0;
		if (memo.containsKey(amount)) return memo.get(amount);

		int coinsRequired = Integer.MAX_VALUE - 1;
		for (int i = 0; i < coins.length; i++) {
			if (amount >= coins[i]) {
				int currentRequired = 1 + findMinimumCoins(coins, amount - coins[i], memo);
				coinsRequired = Math.min(coinsRequired, currentRequired);
			}
		}

		memo.put(amount, coinsRequired);
		return coinsRequired;
	}
}
