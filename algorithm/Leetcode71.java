import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 *
 * Simplify Path
 */
class Leetcode71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        for (String directory : directories) {
            if ("..".equals(directory)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(directory) && !"".equals(directory)) {
                stack.push(directory);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String directory : stack) {
            builder.append("/");
            builder.append(directory);
        }

        return builder.toString().isEmpty() ? "/" : builder.toString();
    }
}