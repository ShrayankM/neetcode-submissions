class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentSet = new ArrayList<>();
		findSubSets(0, nums, result, currentSet);
		return result;
	}

	private void findSubSets(int index, int [] nums, List<List<Integer>> result, List<Integer> currentSet) {
		if (index > nums.length) {
			return;
		}

		result.add(new ArrayList<>(currentSet));
		for (int i = index; i < nums.length; i++) {
			currentSet.add(nums[i]);
			findSubSets(i + 1, nums, result, currentSet);
			currentSet.removeLast();
		}
	}
}
