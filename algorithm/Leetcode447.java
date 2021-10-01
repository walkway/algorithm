import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 * Number of Boomerangs
 */
class Leetcode447 {

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceCounts = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                distanceCounts.put(distance, distanceCounts.getOrDefault(distance, 0) + 1);
            }

            for (int count : distanceCounts.values()) {
                result += count * (count - 1);
            }
        }

        return result;
    }
}