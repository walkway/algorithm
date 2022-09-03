import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * Word Break
 */
class Leetcode139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }

            for (String word : wordDict) {
                int length = word.length();
                int endIndex = i + length;
                if (endIndex > s.length() || dp[endIndex]) {
                    continue;
                }

                if (s.substring(i, endIndex).equals(word)) {
                    dp[endIndex] = true;
                }
            }
        }

        return dp[s.length()];
    }
}