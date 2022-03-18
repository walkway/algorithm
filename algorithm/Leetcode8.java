/**
 * https://leetcode.com/problems/string-to-integer-atoi
 * String to Integer (atoi)
 */
class Leetcode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        StringBuilder atoi = new StringBuilder();
        while (index < s.length()) {
            char character = s.charAt(index);
            if (character < '0' || character > '9') {
                break;
            }

            atoi.append(character);
            index++;
        }

        if (atoi.toString().length() == 0) {
            return 0;
        }

        double result = Double.parseDouble(atoi.toString()) * sign;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

}
