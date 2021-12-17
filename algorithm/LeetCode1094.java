/**
 * https://leetcode.com/problems/car-pooling/
 * Car Pooling
 */
public class LeetCode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int locations[] = new int[1001];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            locations[start] += passengers;
            locations[end] -= passengers;
        }

        int count = 0;
        for (int i = 0; i < 1001; i++) {
            count += locations[i];
            if (count > capacity) {
                return false;
            }
        }

        return true;
    }
}
