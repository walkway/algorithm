import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * Decode String
 */
class Leetcode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<String> strs = new Stack<>();
        Stack<Integer> repeatCounts = new Stack<>();

        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + Character.getNumericValue(s.charAt(index));
                    index++;
                }
                repeatCounts.push(count);
            } else if (s.charAt(index) == '[') {
                strs.push(result.toString());
                result.setLength(0);
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder repeatedString = new StringBuilder(strs.pop());
                int repeatCount = repeatCounts.pop();
                for (int i = 0; i < repeatCount; i++) {
                    repeatedString.append(result);
                }
                result = repeatedString;
                index++;
            } else {
                result.append(s.charAt(index));
                index++;
            }
        }

        return result.toString();
    }
}