class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet();

        for (int n : nums) {
            if (unique.contains(n)) return true;

            unique.add(n);
        }
        return false;
    }
}