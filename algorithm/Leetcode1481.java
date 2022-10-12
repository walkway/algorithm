import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * Least Number of Unique Integers after K Removals
 */
class Leetcode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> sorted = countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        int removed = k;
        while (removed > 0) {
            for (Map.Entry<Integer, Integer> numbers : sorted.entrySet()) {
                int key = numbers.getKey();
                int value = numbers.getValue();
                if (value <= removed) {
                    removed -= value;
                    sorted.remove(key);
                } else {
                    removed -= value;
                    break;
                }

                break;
            }

        }

        return sorted.size();
    }
}