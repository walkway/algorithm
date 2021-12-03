import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Palindrome Partitioning
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);

        return result;
    }

    public void helper(String s, List<String> step, List<List<String>> result) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (!isPalindrome(temp)) {
                continue;
            }

            step.add(temp);
            helper(s.substring(i), step, result);
            step.remove(step.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
