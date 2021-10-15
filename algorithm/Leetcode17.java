import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Letter Combinations of a Phone Number
 */
class Leetcode17 {
    private char[][] phone = new char[][]{{'0'},
            {'0'},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        int[] numbers = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            numbers[i] = Character.getNumericValue(digits.charAt(i));
        }

        List<char[]> digitLetters = new ArrayList<>();
        for (int number : numbers) {
            digitLetters.add(phone[number]);
        }

        combinations(digitLetters, new StringBuilder(), 0);

        return result;
    }

    private void combinations(List<char[]> digitLetters, StringBuilder combinationString, int index) {
        if (index == digitLetters.size()) {
            result.add(combinationString.toString());

            return;
        }

        char[] lettersByNumber = digitLetters.get(index);
        for (char letter : lettersByNumber) {
            combinationString.append(letter);
            combinations(digitLetters, combinationString, index + 1);
            combinationString.setLength(combinationString.length() - 1);
        }
    }
}