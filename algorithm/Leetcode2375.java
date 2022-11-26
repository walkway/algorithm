import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/
 * Construct Smallest Number From DI String
 */
class Leetcode2375 {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }

}