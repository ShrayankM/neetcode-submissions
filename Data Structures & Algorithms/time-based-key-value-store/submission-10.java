public class TimeMap {
	static class Data {
		String value;
		int timeStamp;

		public Data(String value, int timeStamp) {
			this.value = value;
			this.timeStamp = timeStamp;
		}
	}

	Map<String, List<Data>> timeMap;
	public TimeMap() {
		timeMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		timeMap.computeIfAbsent(key, t -> new ArrayList<>()).add(new Data(value, timestamp));
	}

	public String get(String key, int timestamp) {
		List<Data> dataList = timeMap.get(key);
		if (dataList == null || dataList.isEmpty()) return "";

		int i = 0; int j = dataList.size() - 1;
		String result = "";
		while (i <= j) {
			int mid = i + (j - i) / 2;

			if (dataList.get(mid).timeStamp <= timestamp) {
				result = dataList.get(mid).value;
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return result;
	}
}
