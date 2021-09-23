import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 * Reorganize String
 */
class Leetcode767 {
    public String reorganizeString(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char character : s.toCharArray()) {
            int count = characterCounts.getOrDefault(character, 0) + 1;
            if (count > (s.length() + 1) / 2) {
                return "";
            }
            characterCounts.put(character, count);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((o1, o2) -> characterCounts.get(o2) - characterCounts.get(o1));
        heap.addAll(characterCounts.keySet());

        StringBuilder result = new StringBuilder();
        while (heap.size() > 1) {
            char current = heap.remove();
            char next = heap.remove();
            result.append(current);
            result.append(next);
            characterCounts.put(current, characterCounts.get(current) - 1);
            characterCounts.put(next, characterCounts.get(next) - 1);
            if (characterCounts.get(current) > 0) {
                heap.add(current);
            }
            if (characterCounts.get(next) > 0) {
                heap.add(next);
            }
        }

        if (!heap.isEmpty()) {
            char current = heap.remove();
            result.append(current);
        }

        return result.toString();
    }
}