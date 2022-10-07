import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Reverse Words in a String
 */
class Leetcode151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (!word.equals("")) {
                stack.add(word);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}