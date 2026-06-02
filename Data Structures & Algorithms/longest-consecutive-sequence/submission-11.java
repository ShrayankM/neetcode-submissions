class Solution {
    public int longestConsecutive(int[] nums) {
		Set<Integer> uniqueElements = new HashSet<>();
		for (int number : nums) uniqueElements.add(number);

        if (uniqueElements.isEmpty()) return 0;
		
		int maxLength = 1;
		for (int currentElement : uniqueElements) {
			if (uniqueElements.contains(currentElement - 1)) {
				continue;
			}
			
			int currentMaxLenth = 0;
			while (uniqueElements.contains(currentElement++)) currentMaxLenth++;
			maxLength = Math.max(maxLength, currentMaxLenth);
		}
		return maxLength;
	}
}
