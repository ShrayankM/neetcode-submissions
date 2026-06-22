class Solution {
    public boolean canJump(int[] nums) {
		int [] memo = new int [nums.length];
		Arrays.fill(memo, -1);

		int [] result = new int []{0};
		jump(0, nums, result, memo);
		return result[0] > 0;
	}

	private static void jump(int index, int [] nums, int [] result, int [] memo) {
		if (result[0] > 0) return;

		if (index >= nums.length - 1) {
			result[0]++;
			return;
		}

		if (memo[index] != -1) result[0] = result[0] + memo[index];

		int jumpsPossible = nums[index];
		for (int i = 1; i <= jumpsPossible; i++) {
			jump(index + i, nums, result, memo);
		}
		memo[index] = result[0];
	}
}
