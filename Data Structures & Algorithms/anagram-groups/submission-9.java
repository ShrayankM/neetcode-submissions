class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groupMap = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			String key = getKey(s);
			groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
		}
		return groupMap.values().stream().toList();
	}

	private static String getKey(String str) {
		int [] frequency = new int [26];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			frequency[c - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < frequency.length; i++) {
			sb.append(frequency[i]).append("#");
		}
		return sb.toString();
	}
}
