import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/
 * H-Index
 */
class Leetcode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int hindex = citations.length - i;

            if (citations[i] >= hindex) {
                return hindex;
            }
        }

        return result;
    }
}