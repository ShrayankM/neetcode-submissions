class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<Integer> currentSet = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		findCombinations(0, 0, nums, currentSet, target, result);
		return result;
	}

	private void findCombinations(int start, int runningSum, int [] nums, List<Integer> currentSet, int target,
			List<List<Integer>> result) {
		if (runningSum > target) return;

		if (runningSum == target) {
			result.add(new ArrayList<>(currentSet));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			currentSet.add(nums[i]);
			runningSum = runningSum + nums[i];

			findCombinations(i, runningSum, nums, currentSet, target, result);
			currentSet.removeLast();
			runningSum = runningSum - nums[i];
		}
	}
}
