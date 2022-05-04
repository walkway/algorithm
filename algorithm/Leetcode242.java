import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Valid Anagram
 */
class Leetcode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Integer current = charCounts.get(s.charAt(i));
            if (current == null) {
                current = 0;
            }

            charCounts.put(s.charAt(i), current + 1);

            current = charCounts.get(t.charAt(i));
            if (current == null) {
                current = 0;
            }

            charCounts.put(t.charAt(i), current - 1);
        }

        for (Integer i : charCounts.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}