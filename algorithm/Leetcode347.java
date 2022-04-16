import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Top K Frequent Elements
 */
class Leetcode347 {
    public static void main(String args[]) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int num : nums) {
            frequent.put(num, frequent.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(frequent.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
}