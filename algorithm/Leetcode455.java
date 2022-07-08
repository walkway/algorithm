import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * Assign Cookies
 */
class Leetcode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int result = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
            }
            j++;
        }

        return result;
    }
}