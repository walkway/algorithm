import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * Sort Characters By Frequency
 */
class Leetcode451 {

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyCharacters = new HashMap<>();
        for (char aString : s.toCharArray()) {
            frequencyCharacters.put(aString, frequencyCharacters.getOrDefault(aString, 0) + 1);
        }
        List<Character> keySet = new ArrayList<>(frequencyCharacters.keySet());
        keySet.sort((value1, value2) -> (frequencyCharacters.get(value2).compareTo(frequencyCharacters.get(value1))));
        StringBuilder builder = new StringBuilder();
        for (Character key : keySet) {
            int count = frequencyCharacters.get(key);
            for (int i = 0; i < count; i++) {
                builder.append(key);
            }
        }

        return builder.toString();
    }

}