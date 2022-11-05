import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 * Split a String Into the Max Number of Unique Substrings
 */
class Leetcode1593 {

    private int max = 0;

    public int maxUniqueSplit(String s) {
        Set<String> subStrings = new HashSet();
        backtrack(s, 0, subStrings);
        return max;
    }


    private void backtrack(String s, int index, Set<String> subStrings) {
        if (index == s.length()) {
            max = Math.max(max, subStrings.size());
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (!subStrings.contains(substring)) {
                subStrings.add(substring);
                backtrack(s, i, subStrings);
                subStrings.remove(substring);
            }
        }
    }

}