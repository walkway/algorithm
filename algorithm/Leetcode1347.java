import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * Minimum Number of Steps to Make Two Strings Anagram
 */
class Leetcode1347 {

    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
    }

    public static int minSteps(String s, String t) {
        Map<Character, Integer> characters = new HashMap<>();
        for (char charElement : s.toCharArray()) {
            characters.put(charElement, characters.getOrDefault(charElement, 0) + 1);
        }

        int count = 0;
        for (char charElement : t.toCharArray()) {
            if (characters.containsKey(charElement)) {
                if (characters.get(charElement) > 0) {
                    count++;
                }
                characters.put(charElement, characters.get(charElement) - 1);
            }
        }

        return s.length() - count;
    }
}
