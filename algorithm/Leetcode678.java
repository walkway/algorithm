/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 * Valid Parenthesis String
 */
class Leetcode678 {
    public static void main(String[] args) {
        System.out.println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
    }

    public static boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == '*') {
                low--;
                high++;
            } else {
                low--;
                high--;
                if (high < 0) {
                    break;
                }
            }

            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}