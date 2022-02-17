/**
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * Minimum Length of String After Deleting Similar Ends
 */
class Leetcode1750 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                char temp = s.charAt(left);
                while (s.charAt(left) == temp && left < right) {
                    left++;
                }
                while (s.charAt(right) == temp && left <= right) {
                    right--;
                }
            } else {
                break;
            }
        }
        return right - left + 1;
    }
}