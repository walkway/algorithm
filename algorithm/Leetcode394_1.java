import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * Decode String
 */
class Leetcode394_1 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Pattern pattern = Pattern.compile("(\\d+)\\[([a-z]*)]");
        Matcher matcher;
        StringBuffer stringBuffer = new StringBuffer(s);
        while (stringBuffer.indexOf("[") >= 0) {
            matcher = pattern.matcher(stringBuffer);
            stringBuffer = new StringBuffer();
            while (matcher.find()) {
                StringBuilder stringBuilder = new StringBuilder();
                int n = Integer.parseInt(matcher.group(1));
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, stringBuilder.toString());
            }
            matcher.appendTail(stringBuffer);
        }
        return stringBuffer.toString();
    }
}