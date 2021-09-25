import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 * Reorganize String
 */
class Leetcode767_1 {
    public String reorganizeString(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char character : s.toCharArray()) {
            int count = characterCounts.getOrDefault(character, 0) + 1;
            if (count > (s.length() + 1) / 2) {
                return "";
            }
            characterCounts.put(character, count);
        }

        PriorityQueue<CharacterCount> heap = new PriorityQueue<>();
        for (Character character : characterCounts.keySet()) {
            heap.offer(new CharacterCount(character, characterCounts.get(character)));
        }

        StringBuilder result = new StringBuilder();
        while (heap.size() > 1) {
            CharacterCount current = heap.remove();
            CharacterCount next = heap.remove();
            result.append(current.getCharacter());
            result.append(next.getCharacter());

            current.minusCount();
            next.minusCount();

            if (current.remainCount()) {
                heap.add(current);
            }
            if (next.remainCount()) {
                heap.add(next);
            }
        }

        if (!heap.isEmpty()) {
            CharacterCount current = heap.remove();
            result.append(current.getCharacter());
        }

        return result.toString();
    }

    public class CharacterCount implements Comparable<CharacterCount>{
        private char character;
        private int count;

        public CharacterCount(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public char getCharacter() {
            return character;
        }

        public void minusCount() {
            this.count = count - 1;
        }

        public boolean remainCount() {
            return this.count != 0 ? true : false;
        }

        @Override
        public int compareTo(CharacterCount other) {
            return other.count - this.count;
        }
    }
}