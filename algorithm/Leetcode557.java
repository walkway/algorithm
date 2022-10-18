/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Reverse Words in a String III
 */
class Leetcode557 {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split(" ")) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }

}