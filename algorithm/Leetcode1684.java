import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings
 * Count the Number of Consistent Strings
 */
class Leetcode1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for (String s : words) {
            int check = 1;
            for (char c : s.toCharArray()) {
                if (!set.contains(c)) {
                    check = 0;
                }
            }

            if (check == 1) {
                count++;
            }
        }

        return count;
    }

}