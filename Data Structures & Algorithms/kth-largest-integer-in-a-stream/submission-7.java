class KthLargest {
	private PriorityQueue<Integer> priorityQueue;
	private final int k;

	public KthLargest(int k, int[] nums) {
		this.priorityQueue = new PriorityQueue<>();
		this.k = k;

		for (int i = 0; i < nums.length; i++) {
			this.priorityQueue.offer(nums[i]);

			if (this.priorityQueue.size() > k) {
				this.priorityQueue.poll();
			}
		}
	}

	public int add(int val) {
		this.priorityQueue.offer(val);

		if (this.priorityQueue.size() > k) {
			this.priorityQueue.poll();
		}

		if (!this.priorityQueue.isEmpty()) return this.priorityQueue.peek();
		return -1;
	}
}
