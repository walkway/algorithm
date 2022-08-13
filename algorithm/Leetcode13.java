import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * Roman to Integer
 */
class Leetcode13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> symbolValues = new HashMap<>();
        symbolValues.put("I", 1);
        symbolValues.put("V", 5);
        symbolValues.put("X", 10);
        symbolValues.put("L", 50);
        symbolValues.put("C", 100);
        symbolValues.put("D", 500);
        symbolValues.put("M", 1000);
        symbolValues.put("IV", 4);
        symbolValues.put("IX", 9);
        symbolValues.put("XL", 40);
        symbolValues.put("XC", 90);
        symbolValues.put("CD", 400);
        symbolValues.put("CM", 900);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result += symbolValues.get(String.valueOf(s.charAt(i)));
                break;
            }

            Integer number = symbolValues.get(s.charAt(i) + String.valueOf(s.charAt(i + 1)));
            if (number != null) {
                result += number;
                i++;
            } else {
                result += symbolValues.get(String.valueOf(s.charAt(i)));
            }
        }

        return result;
    }
}